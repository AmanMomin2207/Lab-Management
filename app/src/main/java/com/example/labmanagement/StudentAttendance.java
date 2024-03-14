package com.example.labmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import java.util.Date;
import java.time.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class StudentAttendance extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Databasehelper myDb, myDb1;
    EditText tname, dates;
    Button details;
    Spinner yrs,subs,ty,ats;
    String[] year={"YEAR","FY","SY","TY"};
    String[] type={"TYPE","LAB","LECTURE"};
    String[] sub={"SUBJECT","C","OS","JAVA","CN"};
    String[] attends={"Attendance","P","A"};
    String y,t,s,a;
    Button bak;
    LocalDate dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);
        tname = (EditText) findViewById(R.id.tnnname_et);
        dates = (EditText) findViewById(R.id.sub_et);
        yrs = (Spinner) findViewById(R.id.yr_et);
        ty = (Spinner) findViewById(R.id.syr_et);
        ats=(Spinner) findViewById(R.id.pa_et);
        details = (Button) findViewById(R.id.adddet_bt);
        //Date adt=new Date();
        dt=LocalDate.now();
        String dt1=dt.toString();
        dates.setText(dt1);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,year);
        yrs.setOnItemSelectedListener(this);
        ty.setOnItemSelectedListener(this);
        ats.setOnItemSelectedListener(this);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter yt = new ArrayAdapter(this,android.R.layout.simple_spinner_item,type);
        yt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter atds = new ArrayAdapter(this,android.R.layout.simple_spinner_item,attends);
        atds.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter subj = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sub);
        subj.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yrs.setAdapter(aa);
        ty.setAdapter(yt);
        ats.setAdapter(subj);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Cursor res = myDb1.getteacherSubjectdetails(tname.getText().toString(),subname.getText().toString(),stype.getText().toString());
                //if (res.getCount() == 0) {
                // show message
                try {


                    boolean isInserted = true;

                    if (isInserted == true)
                        showMessage("Student Evaluation", "Teacher Activity Added");


                    else
                        showMessage("Error", "Teacher Activity Not Registered");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            });




    }

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
                switch (arg0.getId()) {
                    case R.id.yr_et:
                        y = year[position];
                        break;
                    case R.id.subtypes_et:
                        t = type[position];
                        break;
                    case R.id.pa_et:
                        a = attends[position];
                        break;
                    case R.id.syr_et:
                        s = sub[position];
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

            }
            public void showMessage(String title, String Message) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(Message);
                builder.show();
            }
}