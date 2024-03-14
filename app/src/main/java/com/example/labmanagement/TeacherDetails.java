package com.example.labmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.database.Cursor;
import android.app.AlertDialog;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class TeacherDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Databasehelper myDb, myDb1;
    EditText tname, subname;
    ImageButton details;
    Spinner yrs,credit,ty;
    Button bak;
    String[] year={"YEAR","FY","SY","TY"};
    String[] type={"TYPE","LAB","LECTURE"};
    String[] cre={"SLOT","5","3","1"};
    String y,t,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_details);
        myDb = new Databasehelper(this);
        myDb1 = new Databasehelper(this);
        tname = (EditText) findViewById(R.id.tnnname_et);
        subname = (EditText) findViewById(R.id.sub_et);
        yrs = (Spinner) findViewById(R.id.yr_et);
        ty = (Spinner) findViewById(R.id.subtypes_et);
        credit=(Spinner) findViewById(R.id.cr_et);
        details = (ImageButton) findViewById(R.id.adddet_bt);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,year);
        yrs.setOnItemSelectedListener(this);
        ty.setOnItemSelectedListener(this);
        credit.setOnItemSelectedListener(this);
        bak = (Button) findViewById(R.id.bk);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter yt = new ArrayAdapter(this,android.R.layout.simple_spinner_item,type);
        yt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter cr = new ArrayAdapter(this,android.R.layout.simple_spinner_item,cre);
        //cr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        yrs.setAdapter(aa);
        ty.setAdapter(yt);
        //credit.setAdapter(cr);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Cursor res = myDb1.getteacherSubjectdetails(tname.getText().toString(),subname.getText().toString(),stype.getText().toString());
                //if (res.getCount() == 0) {
                // show message
               // try {


                  //  boolean isInserted = myDb.SubjectData(tname.getText().toString(), subname.getText().toString(), y, t, c);
                    // boolean isInserted = myDb.SubjectData("XYZ", "C", "BE", "LAB", "5");
                   /* if (isInserted == true)
                        showMessage("Student Evaluation", "Teacher Activity Added");


                    else
                        showMessage("Error", "Teacher Activity Not Registered");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }*/
            }
            //else {
            //showMessage("Error", "Already Registered");
            //return;
            //}
            //}
        });

        bak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newintent=new Intent(TeacherDetails.this,DashboardActivity.class);
                startActivity(newintent);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        switch(arg0.getId())
        {
            case R.id.yr_et:
                y=year[position];
                Toast.makeText(getApplicationContext(),year[position],Toast.LENGTH_LONG).show();
                break;
            case R.id.subtypes_et:
                t=type[position];
                break;
            case R.id.cr_et:
                c=cre[position];
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