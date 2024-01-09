package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class FetchDataActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    ArrayList weight, heightFT, height, result;
    DBHelperBMI db1;
    MyAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        db1 = new DBHelperBMI(this);
        weight = new ArrayList();
        heightFT = new ArrayList();
        height = new ArrayList();
        result = new ArrayList();
        recyclerview = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this, weight, heightFT, height, result);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        displayData();

    }

    private void displayData() {
        Cursor cursor = db1.fetchData();
        if (cursor.getCount()==0) {
            Toast.makeText(this, "No data exists", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                weight.add(cursor.getString(1));
                heightFT.add(cursor.getString(2));
                height.add(cursor.getString(3));
                result.add(cursor.getString(4));
            }
        }
    }
}