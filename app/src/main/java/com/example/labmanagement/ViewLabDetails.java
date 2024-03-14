package com.example.labmanagement;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewLabDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lab_details);
        String[] JavaStudentArray = {"Avi","Keshi","Aryan","Keshavi",""

                };



        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, JavaStudentArray);

        ListView listView = (ListView) findViewById(R.id.teacher_list);
        listView.setAdapter(adapter);

    }
}