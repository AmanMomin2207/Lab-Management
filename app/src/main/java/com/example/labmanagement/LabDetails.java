package com.example.labmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LabDetails extends AppCompatActivity {

    TextView tn1,tn2,tn3;
    TextView l1,l2,l3;
    TextView st1,st2,st3;
    Button backbt,moveat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_details);
        GlobalData application = (GlobalData) getApplication();
        tn1=(TextView) findViewById(R.id.tv_tn1);
        tn2=(TextView) findViewById(R.id.tv_tn2);
        tn3=(TextView) findViewById(R.id.tv_tn3);
        l1=(TextView) findViewById(R.id.tv_ln1);
        l2=(TextView) findViewById(R.id.tv_ln2);
        l3=(TextView) findViewById(R.id.tv_ln3);
        st1=(TextView) findViewById(R.id.tv_st1);
        st2=(TextView) findViewById(R.id.tv_st2);
        st3=(TextView) findViewById(R.id.tv_st3);
        backbt=(Button) findViewById(R.id.bkd);
        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent attend=new Intent(getApplicationContext(),AttendanceListdata .class);
               startActivity(attend);

            }
        });
        String un[]=application.getuname();
        String ln[]=application.getlname();

        tn1.setText(un[0]);
        tn2.setText(un[1]);
        tn3.setText(un[2]);
        l1.setText(ln[0]);
        l2.setText(ln[1]);
        l3.setText(ln[3]);

        if(un[0]!=null)
        {
            st1.setText("ACTIVE");
        }
        else
        if(un[1]!=null) {
            st2.setText("ACTIVE");
        }
        else
            if(un[2]!=null)
            {
                st3.setText("ACTIVE");
            }

    }

    }
