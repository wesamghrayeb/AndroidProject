package com.example.arabic.restaurants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public  class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db2";
    public static final String USERS_TABLE_NAME = "tblFoodtype";
    public static final String USERS_COLUMN_Name = "Name";
    public static final String USERS_COLUMN_Information = "Information";
    SQLiteDatabase db2;
    private HashMap hm;
    ArrayList<String> aL;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + USERS_TABLE_NAME
                + " (" + USERS_COLUMN_Name + " text primary key not null," + USERS_COLUMN_Information+ " text not null)");
        this.db2 = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tblFoodtype");
        onCreate(db);
    }

    public void InsertInformation(String Name, String Information) {
            db2 = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(USERS_COLUMN_Name, Name);
            cv.put(USERS_COLUMN_Information, Information);
            db2.insert(USERS_TABLE_NAME, null, cv);

    }
    public ArrayList<String> GetInformation(String Name){
        db2=this.getReadableDatabase();
        Cursor res =db2.rawQuery("select " + USERS_COLUMN_Information + " from "  + USERS_TABLE_NAME + " where " + USERS_COLUMN_Name + " = '"  + Name + "'",null);
        aL=new ArrayList<>();
        res.moveToFirst();
       if (res.moveToFirst())
       {
           aL.add(res.getString(0));
           res.close();
       }
       res.close();
       return aL;
    }

}