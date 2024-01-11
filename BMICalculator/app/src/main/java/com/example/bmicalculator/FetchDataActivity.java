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
//    ArrayList<Model> dataList = new ArrayList<>();
    DBHelperBMI db1;
    MyAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        db1 = new DBHelperBMI(this);
        recyclerview = findViewById(R.id.recyclerview);
//        displayData();

    }

    public void displayData() {
        Cursor cursor = db1.fetchData();
        ArrayList<Model> dataList = new ArrayList<>();
        if (cursor.getCount()==0) {
            Toast.makeText(this, "No data exists", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                int weight = cursor.getInt(1);
                int heightFT = cursor.getInt(2);
                int height = cursor.getInt(3);
                int result = cursor.getInt(4);
                dataList.add(new Model(weight, heightFT, height, result));
            }
            adapter = new MyAdapter(this, dataList);
            recyclerview.setAdapter(adapter);
            recyclerview.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}