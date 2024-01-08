package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    Button btnSignup, btnLogin, btnLoginSignup;
    EditText usernameSignup, passwordSignup, confirmPasswordSignup;
    DBHelper db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // SignUp
        btnSignup = findViewById(R.id.btnSignup);
        btnLoginSignup = findViewById(R.id.btnLoginSignup);
        usernameSignup = findViewById(R.id.usernameSignup);
        passwordSignup = findViewById(R.id.passwordSignup);
        confirmPasswordSignup = findViewById(R.id.confirmPasswordSignup);

        db = new DBHelper(this);

        //SignUpLogin button
        btnLoginSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, Login.class);
                startActivity(intent);
            }
        });

        // SignUp button
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usernameSignup.getText().toString();
                String pass = passwordSignup.getText().toString();
                String confirmpass = confirmPasswordSignup.getText().toString();

                if (user.equals("")||pass.equals("")||confirmpass.equals("")) {
                    Toast.makeText(SignUpActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(confirmpass)) {
                        boolean checkuser = db.checkusername(user);
                        if (checkuser==false) {
                            boolean insert = db.insertData(user, pass);
                            if (insert==true) {
                                Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, BMI.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUpActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}