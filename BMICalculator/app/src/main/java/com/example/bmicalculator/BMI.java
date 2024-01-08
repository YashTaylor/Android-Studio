package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    TextView result;
    EditText height, heightFT, weight;
    LinearLayout LLMain;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);
        result = findViewById(R.id.result);
        height = findViewById(R.id.height);
        heightFT = findViewById(R.id.heightFT);
        weight = findViewById(R.id.weight);
        LLMain = findViewById(R.id.LLMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(weight.getText().toString());
                int in = Integer.parseInt(height.getText().toString());
                int ft = Integer.parseInt(heightFT.getText().toString());

                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;
                double bmi = wt / (totalM * totalM);

                if (bmi > 25) {
                    result.setText("You are Overweight.");
                    LLMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi < 18) {
                    result.setText("You are Underweight.");
                    LLMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                } else {
                    result.setText("You are Healthy.");
                    LLMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }
        });



    }
}