package com.example.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ContactsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_no";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATE TABLE contacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_no TEXT);
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                "(" + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + "TEXT UNIQUE, "
                + KEY_PHONE_NO + "TEXT" + ")");

//        SQLiteDatabase database = this.getWritableDatabase();// if reference is not found use this

        // execute queries here // insert ,update, delete, etc.

//        database.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addContacts(String name, String phone_no) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PHONE_NO, phone_no);

        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<ContactModel> fetchContacts(){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ContactModel> arrContacts = new ArrayList<>();

        while (cursor.moveToNext()) {
            ContactModel model = new ContactModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phone_no = cursor.getString(2);

            arrContacts.add(model);
        }
        return arrContacts;
    }
}
