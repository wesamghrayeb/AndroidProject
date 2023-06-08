package com.example.arabic.restaurants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class FeedbackDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db3";
    public static final String USERS_TABLE_NAME = "feedback";
    public static final String USERS_COLUMN_Name = "feedb";
    SQLiteDatabase db3;
    ArrayList<String> aL;

    public FeedbackDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + USERS_TABLE_NAME
                + " (" + USERS_COLUMN_Name + " text primary key not null)");
        this.db3 = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS feedback");
        onCreate(db);
    }

    public void AddFeed(String feed) {
        db3 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USERS_COLUMN_Name, feed);

        db3.insert(USERS_TABLE_NAME, null, cv);
        //db.update(USERS_TABLE_NAME,cv,USERS_COLUMN_Name +"='"+username + "'",null);
    }

    public ArrayList<String> Getfeed() {
        db3 = this.getReadableDatabase();
        Cursor res = db3.rawQuery("select * from " + USERS_TABLE_NAME, null);
        aL = new ArrayList<>();
        res.moveToFirst();
        if (res.moveToFirst()) {
            int iName = res.getColumnIndex(USERS_COLUMN_Name);
            for (res.moveToFirst(); !res.isAfterLast(); res.moveToNext()) {
                aL.add(res.getString(iName));
            }
        }
        res.close();
        return aL;
    }
}
