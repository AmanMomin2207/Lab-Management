package com.example.labmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import android.os.Bundle;

public class DashboardActivity extends AppCompatActivity {
    ImageButton stu_add,atd_view,par_mail,time_table,vw;
    Button back_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        stu_add =(ImageButton)findViewById(R.id.stuadd_ibt);
        atd_view=(ImageButton)findViewById(R.id.att_ibt);
        par_mail=(ImageButton)findViewById(R.id.pmail_ibt);
        time_table=(ImageButton)findViewById(R.id.tt_ibt);
        vw=(ImageButton)findViewById(R.id.att_ibtt1);
        back_bt=(Button)findViewById(R.id.bt_back);
        stu_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this,RegisterUsers.class);
                startActivity(i);

            }
        });
       atd_view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(DashboardActivity.this,StudentAttendance.class);
               startActivity(i);
           }
       });
        vw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this,LabDetails.class);
                startActivity(i);

            }
        });
        par_mail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this,SendMail.class);
                startActivity(i);
            }
        });

        back_bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(i);
                System.exit(0);
            }
        });
        time_table.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this,TeacherDetails.class);
                startActivity(i);
            }
        });

    }
}