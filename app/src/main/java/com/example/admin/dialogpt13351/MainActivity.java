package com.example.admin.dialogpt13351;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showTimePickerDialog(View view) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);

        // khoi tao PickerDialog

        TimePickerDialog time = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this, i+":"+i1, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, true);
        // hien thi
        time.show();

    }

    public void showDatePickerDialog(View view) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //Buoc2: khoi tao date picker dialog
        DatePickerDialog date = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, i2+  "/"     + (+i1+1) +   "/"    +i , Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);

        // buoc 3 : hien thi
        date.show();
    }

    public void showProgressDialog(View view) {
        //buoc 1 : dinh nghia progress dialog
        final ProgressDialog dialog = new ProgressDialog(this);

        //buoc 2 : thiet lap thong tin ( title,  message, button)
        dialog.setTitle("Loading ...");
        dialog.setMessage("Do you want to cancle?");
        dialog.setButton(ProgressDialog.BUTTON_POSITIVE, "yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        dialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        // neu muon hien thi thanh trang thai
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // hien thi
        dialog.show();
        //thiet lap gia tri hien thi %
        dialog.setProgress(60);// ( vi du gia tri la 60 % )
    }

    public void showAlertDialog(View view) {
        //b1 : khoi tao alert
        AlertDialog.Builder BUILDER = new AlertDialog.Builder(this);

        // buoc 2: thiet lap thong title, message,button
        BUILDER.setTitle ("Thong bao");
        BUILDER.setMessage("Ban co muon thoat chuong trinh?");
        BUILDER.setPositiveButton("co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        BUILDER.setNegativeButton("khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        // buoc 3 : hien thi
        BUILDER.show();
    }

    public void showAlertListDialog(View view) {
        // buoc 1
        AlertDialog.Builder builder = new AlertDialog.Builder(this );

        // buoc 2 thiet lap thong tin: title, body, boton
        final String[] lops = {"PT13351", "PT13352", "PT13353", "PT13354","PT13355"};
        builder.setTitle("Chon lop");
        builder.setItems(lops, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, lops[i],
                        Toast.LENGTH_SHORT).show();
            }
        });
        // buoc 3 hien thi
        builder.show();

    }

    public void showSingleChoiceDialog(View view) {
        //buoc 1 : dinh nghia alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // buoc 2: thiet lap thong tin
        builder.setTitle("Chon lop");
        final String[] lops = {"PT13351", "PT13352", "PT13353", "PT13354","PT13355"};
        builder.setSingleChoiceItems(lops, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, lops[i],
                Toast.LENGTH_SHORT).show();
            }
        });
        // buoc 3 : hien thi
        builder.show();

    }

    public void showMultiChoiceDialog(View view) {
        // buoc 1:
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // buoc 2 : thiet lap thog tin
        builder.setTitle("Chon lop");
        final String[] lops = {"PT13351", "PT13352", "PT13353", "PT13354","PT13355"};
        boolean[] ketQuaChon = {false,true,true,false,false};
        builder.setMultiChoiceItems(lops, ketQuaChon, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(MainActivity.this,
                        b?"Chon" : "Bo chon" + lops[i],
                        Toast.LENGTH_SHORT).show();

            }
        });
        //hien thi
        builder.show();

    }

    public void showCustomDialog(View view) {
        //b1 dinh nghia alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //thiet lap thong tin
        builder.setTitle("Dang Nhap");

        // tao 1 view tu 1 file layout bang layoutinflater
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewDialog = inflater.inflate(R.layout.dialog_login,null );
        builder.setView(viewDialog);

        // khai bao, khoi tao cac thanh phan trong dialo
        final EditText edTen = viewDialog.findViewById(R.id.edTen);
        final EditText edMatKau = viewDialog.findViewById(R.id.edmatKhau);

        // tao 2 buton dang nhap va huy
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("Huy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //TODO: lay usedname, password
                String ten = edTen.getText().toString();
                String matkhau = edMatKau.getText().toString();

            }
        });

        // buoc 3 hien thi
        builder.show();
    }

    public void showCustomToast(View view) {
        Toast toast = new Toast(this);
        //b2 thiet lap thong tin
        //tao 1 view tu 1 file layout bang layout inflater
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewtoast = inflater.inflate(R.layout.dialog_login,null);
        toast.setView(viewtoast);

        // buoc 3 hien thi
        toast.show();

    }
}
