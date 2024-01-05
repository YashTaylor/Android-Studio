package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button next = findViewById(R.id.next);
        Intent iNext = new Intent(MainActivity.this, SecondActivity.class);

        iNext.putExtra("title", "Home");
        iNext.putExtra("studentName", "Yash");
        iNext.putExtra("rollNo", 10);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iNext);
            }
        });

    }
}