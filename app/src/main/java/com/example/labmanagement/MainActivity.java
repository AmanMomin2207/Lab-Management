package com.example.labmanagement;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button regibtn,signin,forget;
    EditText un,ups;
    Spinner lablist;
    Databasehelper myDb;
    String lnm;
    String[] sub={"LABS","C","OS","JAVA","CN"};
    //GlobalData GD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GlobalData application = (GlobalData) getApplication();
       // actionBar.setTitle("Lab Management");
        myDb=new Databasehelper(this);
       // regibtn=(Button)findViewById(R.id.regi1);
        lablist=(Spinner)findViewById(R.id.lab_sp);

        ArrayAdapter subj = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sub);
        subj.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lablist.setAdapter(subj);
        lablist.setOnItemSelectedListener(this);
        signin=(Button) findViewById(R.id.signin);
        un=(EditText)findViewById(R.id.un) ;
        ups=(EditText)findViewById(R.id.ps);
        forget=(Button)findViewById(R.id.forgot);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mail=new Intent(MainActivity.this,SendMail.class);
                startActivity(mail);

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (un.getText().toString().equals("admin") && ups.getText().toString().equals("admin123")) {

                    Intent dboard = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(dboard);
                } else {
                    if (Patterns.EMAIL_ADDRESS.matcher(un.getText().toString()).matches() && un.length() > 0) {
                        if (ups.length() > 0) {

                            Cursor res = myDb.checklogin(un.getText().toString(), ups.getText().toString());

                            if (res.getCount() == 0) {
                                showMessage("Error", "Not a Registered User");
                                cleardata();
                                return;
                            } else {
                                res.moveToFirst();
                                String nm=res.getString(1);
                                application.setuname(nm);
                                application.setlabname(lnm);
                                showMessage("Lab Management", "Login Successful");
                                cleardata();
                                Intent sign = new Intent(MainActivity.this, DashboardActivity.class);
                                startActivity(sign);
                            }
                        } else {
                            showMessage("Error", "Not a proper password format");
                            cleardata();

                        }
                    } else {
                        showMessage("Error", "Wrong Email Format");
                        cleardata();
                    }
                }
            }

        });
    }
    void cleardata()
    {
        un.getText().clear();
        ups.getText().clear();
        un.requestFocus();
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        switch (arg0.getId()) {
            case R.id.lab_sp:
                lnm = sub[position];
                break;


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }

    }

