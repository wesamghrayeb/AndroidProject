package com.example.arabic.restaurants;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class ImageDatabase extends SQLiteOpenHelper {
    public Context context;
    ArrayList<Bitmap> al;
    public static final String DATABASE_NAME = "dataManager";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "data";
    public static final String KEY_ID = "id";
    public static final String KEY_IMG_URL = "ImgFavourite";

    public ImageDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        //Toast.makeText(context, "Constructor called", Toast.LENGTH_LONG).show();
    }

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_IMG_URL + " BLOB " + ")";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + "";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void deleteEntry(long row) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, KEY_ID + "=" + row, null);
    }

    public ArrayList<Bitmap> getTheImage(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = (Cursor) db.rawQuery(" SELECT * FROM "+this.TABLE_NAME,null,null);
        al = new ArrayList<>();
        cursor.moveToFirst();
        if (cursor.moveToFirst()){
            int iName= cursor.getColumnIndex(KEY_IMG_URL);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                byte[] imgByte =  cursor.getBlob(cursor.getColumnIndex(this.KEY_IMG_URL));
                al.add(BitmapFactory.decodeByteArray(imgByte,0,imgByte.length));
            }
            cursor.close();
            return al;
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return null;
    }
}

