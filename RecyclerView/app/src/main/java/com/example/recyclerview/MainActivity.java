package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView recyclerView = findViewById(R.id.recyclerContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"A", "1234567890"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"B", "1234567891"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"C", "1234567892"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"D", "1234567893"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"E", "1234567894"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"F", "1234567895"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"G", "1234567896"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"H", "1234567897"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"I", "1234567898"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"J", "1234567899"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"K", "1234567889"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"L", "1234567888"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"M", "1234567887"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"N", "1234567886"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_background,"O", "1234567885"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground,"P", "1234567884"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}