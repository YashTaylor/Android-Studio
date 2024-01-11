package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BMI extends AppCompatActivity {

    Button btnCalculate, btnLogout, btnFetch, btnDelete;
    TextView result;
    EditText height, heightFT, weight;
    LinearLayout LLMain;
    DBHelperBMI db1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        // Calculator
        btnCalculate = findViewById(R.id.btnCalculate);
        btnLogout = findViewById(R.id.btnLogout);
        btnFetch = findViewById(R.id.btnFetch);
        btnDelete = findViewById(R.id.btnDelete);
        result = findViewById(R.id.result);
        height = findViewById(R.id.height);
        heightFT = findViewById(R.id.heightFT);
        weight = findViewById(R.id.weight);
        LLMain = findViewById(R.id.LLMain);
        db1 = new DBHelperBMI(this);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.valueOf(weight.getText().toString().trim());
                int ft = Integer.valueOf(heightFT.getText().toString().trim());
                int in = Integer.valueOf(height.getText().toString().trim());

                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;

                long result = (long) (wt / (totalM * totalM));
                if (result > 25) {
                    LLMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (result < 18) {
                    LLMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                } else {
                    LLMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
                if (weight.equals("") || heightFT.equals("") || height.equals("")) {
                    Toast.makeText(BMI.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    boolean insert = db1.insertDataBMI(wt, ft, in, result);
                    if (insert) {
                        Toast.makeText(BMI.this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(BMI.this, "Insertion failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        //Fetch Data
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db1.fetchData();
                if (res.getCount()==0){
                    Toast.makeText(BMI.this, "No entry exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Weight: " + res.getString(0) + "\n");
                    buffer.append("HeightFT: " + res.getString(1) + "\n");
                    buffer.append("Height: " + res.getString(2) + "\n");
                    buffer.append("result: " + res.getString(3) + "\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(BMI.this);
                builder.setCancelable(true);
                builder.setTitle("User entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        // delete Data
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Weight = Integer.valueOf(weight.getText().toString());
                if (weight.equals("")) {
                    Toast.makeText(BMI.this, "Please enter the weight", Toast.LENGTH_SHORT).show();
                } else {
                    boolean checkDeleteData = db1.deleteData(Weight);
                    if (checkDeleteData) {
                        Toast.makeText(BMI.this, "Data deleted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(BMI.this, "Data not deleted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Logout
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMI.this, Login.class);
                startActivity(intent);
            }
        });
    }
}