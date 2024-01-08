package com.example.bmicalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperBMI extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="BMIdata";
    public DBHelperBMI(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL("create table bmidata (weight NUMBER PRIMARY KEY, heightFT NUMBER, height NUMBER, result NUMBER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int i, int i1) {
        db1.execSQL("drop table if exists bmidata");
    }

    public boolean insertDataBMI(int weight, int heightFT, int height, long bmi) {

        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("weight", weight);
        content.put("height", heightFT);
        content.put("heightFT", height);
        content.put("bmi", bmi);

        long results = db1.insert("bmidata", null, content);

        if (results == -1) {
            return false;
        } else {
            return true;
        }
    }

}
