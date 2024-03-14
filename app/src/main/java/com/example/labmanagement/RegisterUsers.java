package com.example.labmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.database.Cursor;
import android.widget.Toast;
import java.util.regex.Pattern;
import static android.util.Patterns.EMAIL_ADDRESS;

public class RegisterUsers extends AppCompatActivity {

    Button regi,signin;
    Databasehelper myDb,myDb1;
    EditText emailu,password,name;
    private static final Pattern PASSWORD_PAT =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{6,20}" +                // at least 4 characters
                    "$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_users);
        regi=(Button) findViewById(R.id.regi2);
        signin=(Button) findViewById(R.id.signin2);
        emailu = (EditText)findViewById(R.id.mail);
        password = (EditText)findViewById(R.id.ps);
        name = (EditText)findViewById(R.id.unm);
        myDb = new Databasehelper(this);
        myDb1=new Databasehelper(this);
        regi.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                try {
                    if (EMAIL_ADDRESS.matcher(emailu.getText().toString()).matches() && emailu.length() > 0) {
                        String pword=password.getText().toString();
                        if (PASSWORD_PAT.matcher(pword).matches())
                        {
                            Cursor res = myDb1.check(name.getText().toString(),emailu.getText().toString());
                            if (res.getCount() == 0)
                            {

                                //boolean isInserted = myDb.UserData("abc","abc@gmail.com","abc123");
                                boolean isInserted = myDb.UserData(name.getText().toString(), emailu.getText().toString(), password.getText().toString());
                                if (isInserted == true)
                                    Toast.makeText(RegisterUsers.this,"User Registered", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(RegisterUsers.this, "User Not Registered", Toast.LENGTH_LONG).show();
                            }
                            else {
                                showMessage("Error", "Email Already Registered");
                                cleardata();
                                name.requestFocus();
                                return; }
                        }
                        else
                        {
                            showMessage("Error", "Enter Strong password");
                        }
                    }
                    else

                    {
                        showMessage("Error", "Wrong Email Pattern");
                    }

                }
                catch (Exception e)
                {
                    Toast.makeText(RegisterUsers.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }



            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleardata();
                Intent sign=new Intent(RegisterUsers.this,MainActivity.class);
                startActivity(sign);

            }
        });
    }

    public void cleardata()
    {
        name.getText().clear();
        emailu.getText().clear();
        password.getText().clear();
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    }
