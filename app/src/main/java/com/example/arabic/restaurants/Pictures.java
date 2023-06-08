package com.example.arabic.restaurants;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Pictures extends AppCompatActivity {
    ImageDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);
        database = new ImageDatabase(Pictures.this);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        ArrayList<Bitmap> listData = new ArrayList<>();
        if(database.getTheImage() != null) {
            listData = database.getTheImage();
            for (Bitmap a : listData) {
                ImageView image = new ImageView(this);
                image.setLayoutParams(new android.view.ViewGroup.LayoutParams(350, 450));
                image.setMaxHeight(20);
                image.setMaxWidth(20);
                image.setImageBitmap(a);
                linearLayout.addView(image);
            }
        }
    }
}