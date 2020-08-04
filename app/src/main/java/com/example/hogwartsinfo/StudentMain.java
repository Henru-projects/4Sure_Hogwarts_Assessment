package com.example.hogwartsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class StudentMain extends AppCompatActivity {
    //Vars
    Button loadStudents;
    public static TextView studentData;

    //https://www.potterapi.com/v1/characters?key=$2a$10$1JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP/IUZWIVwfsaF7y
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        loadStudents = (Button) findViewById(R.id.btnLoadStudents);
        studentData = (TextView) findViewById(R.id.lblStudentData);

        loadStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchStudentData process = new fetchStudentData();
                process.execute();
            }
        });
    }


}
