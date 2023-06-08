package com.example.arabic.restaurants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public abstract class USERsDATaBASE extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db";
    public static final String USERS_TABLE_NAME = "user";
    public static final String USERS_COLUMN_Name = "username";
    public static final String USER_COLUMN_PASS = "pass";
    SQLiteDatabase db;
    public USERsDATaBASE(Context context) {super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + USERS_TABLE_NAME
                + " (" + USERS_COLUMN_Name + " text primary key not null,"
                + USER_COLUMN_PASS + " text not null)");
        this.db = db;  //tables for users
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public void AddUser(String username, String password)  //add user
    {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USERS_COLUMN_Name, username);
        cv.put(USER_COLUMN_PASS, password);

        db.insert(USERS_TABLE_NAME, null, cv);
        //db.update(USERS_TABLE_NAME,cv,USERS_COLUMN_Name +"='"+username + "'",null);
    }

    public boolean checkIfuserExists(String username)
    {
        db = this.getReadableDatabase();
        String query = "Select * from " + USERS_TABLE_NAME + " where " + USERS_COLUMN_Name + " = " + "'"+username +"'";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public String logInUser(String username)
    {
        db = this.getReadableDatabase();
        String query = "Select * from " + USERS_TABLE_NAME ;
        String passToReturnAndCompare = "null";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst())
        {
            do {
                String usernameToCompare = cursor.getString(0);
                if(usernameToCompare.equals(username))
                {
                    passToReturnAndCompare = cursor.getString(1);
                }
            }
            while (cursor.moveToNext());
        }
        return passToReturnAndCompare;
    }



    }







