package com.example.bmicalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperBMI extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="BMIData";
    public DBHelperBMI(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL("create table bmi_data (id INTEGER PRIMARY KEY AUTOINCREMENT, weight INTEGER, heightFT INTEGER, height INTEGER, result LONG)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int i, int i1) {
        db1.execSQL("drop table if exists bmi_data");
    }

    public boolean insertDataBMI(int weight, int heightFT, int height, long result) {

        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("weight", weight);
        content.put("heightFT", heightFT);
        content.put("height", height);
        content.put("result", result);

        long results = db1.insert("bmi_data", null, content);

        if (results == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor fetchData() {
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor cursor = db1.rawQuery("select * from bmi_data", null);
        return cursor;
    }

}
