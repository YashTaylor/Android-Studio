package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String sName = fromAct.getStringExtra("studentName");
        int rollNo = fromAct.getIntExtra("rollNo", 0);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView studentName = findViewById(R.id.studentName);

        studentName.setText("RollNo " +rollNo+ "studentName " +sName);
//        getSupportActionBar().setTitle(title);

    }
}