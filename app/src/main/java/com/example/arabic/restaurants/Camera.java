package com.example.arabic.restaurants;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class Camera extends AppCompatActivity {

    private ImageView myImage;
    private Button button16, send;
    byte[] byteArray;
    protected static final int CAMERA_PIC_REQUEST = 0;
    ImageDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_camera );
        myImage = findViewById ( R.id.myImage );
        button16 = findViewById ( R.id.button16 );
        send = findViewById ( R.id.button18 );

        database = new ImageDatabase ( Camera.this ) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                super.onCreate ( db );
            }
        };

        button16.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                takePicture ();
            }
        } );

        send.setOnClickListener ( new OnClickListener () {
            @Override
            public void onClick(View arg0) {
                if (myImage.getDrawable () == null) {
                    Toast.makeText ( Camera.this, "please take a picture", Toast.LENGTH_SHORT ).show ();
                    return;
                }
                SQLiteDatabase db = database.getWritableDatabase ();
                ContentValues values = new ContentValues ();
                values.put ( ImageDatabase.KEY_IMG_URL, byteArray );
                db.insert ( ImageDatabase.TABLE_NAME, null, values );
                db.close ();

                Toast.makeText ( Camera.this, "picture was sent successfully to the admin", Toast.LENGTH_SHORT ).show ();
                return;
            }
        } );


    }

    private void takePicture() {
        Intent i = new Intent ( MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult ( i, 0 );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult ( requestCode, resultCode, data );
        if (resultCode == RESULT_OK) {
            Bitmap b = (Bitmap) data.getExtras ().get ( "data" );
            myImage.setImageBitmap ( b );

            ByteArrayOutputStream stream = new ByteArrayOutputStream ();
            b.compress ( Bitmap.CompressFormat.PNG, 100, stream );
            byteArray = stream.toByteArray ();


        }
    }

}