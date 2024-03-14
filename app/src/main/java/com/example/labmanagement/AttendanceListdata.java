package com.example.labmanagement;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AttendanceListdata extends AppCompatActivity {
    String[] attend={"Attendance","Present","Abscent"};
    Spinner sn1,sn2,sn3,sn4,sn5,sn6,sn7,sn8,sn9,sn10,sn11;
    Button bks,attendent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_listdata);
        sn1=(Spinner) findViewById(R.id.sp_at1);
        sn2=(Spinner) findViewById(R.id.sp_at2);
        sn3=(Spinner) findViewById(R.id.sp_at3);
        sn4=(Spinner) findViewById(R.id.sp_at4);
        sn5=(Spinner) findViewById(R.id.sp_at5);
        sn6=(Spinner) findViewById(R.id.sp_at6);
        sn7=(Spinner) findViewById(R.id.sp_at7);
        sn8=(Spinner) findViewById(R.id.sp_at8);
        sn9=(Spinner) findViewById(R.id.sp_at9);
        sn10=(Spinner) findViewById(R.id.sp_at10);
        sn11=(Spinner) findViewById(R.id.sp_at11);
        ArrayAdapter nm1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn1.setAdapter(nm1);
        ArrayAdapter nm2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn2.setAdapter(nm2);
        ArrayAdapter nm3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn3.setAdapter(nm3);
        ArrayAdapter nm4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn4.setAdapter(nm4);
        ArrayAdapter nm5 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn5.setAdapter(nm5);
        ArrayAdapter nm6 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn6.setAdapter(nm6);
        ArrayAdapter nm7 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn7.setAdapter(nm7);
        ArrayAdapter nm8 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn8.setAdapter(nm8);
        ArrayAdapter nm9 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn9.setAdapter(nm9);
        ArrayAdapter nm10 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn10.setAdapter(nm10);
        ArrayAdapter nm11 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attend);
        nm11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn11.setAdapter(nm11);
        bks=(Button) findViewById(R.id.btbkat);
        attendent=(Button) findViewById(R.id.btattend);
        bks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(AttendanceListdata.this,LabDetails.class);
                startActivity(back);
            }
        });
        attendent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showMessage("Lab","Attendance Stored");
            }
        });

    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}