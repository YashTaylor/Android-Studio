package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbhelper = new DBHelper(this);
//        dbhelper.addContacts("Yash", "9876543210");
//        dbhelper.addContacts("Payal", "9876543211");
//        dbhelper.addContacts("Komal", "9876543212");
//        dbhelper.addContacts("Gaurav", "9876543213");


        ArrayList<ContactModel> arrContacts = dbhelper.fetchContacts();

        for (int i = 0; i < arrContacts.size(); i++) {
            Log.d("Contact_Info", "Name: " + arrContacts.get(i).name + "Phone No: " + arrContacts.get(i).phone_no);

        }


    }
}