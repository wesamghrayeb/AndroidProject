package com.example.arabic.restaurants;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class adminClass extends AppCompatActivity {
    TextView tv;
    Button photos;
    FeedbackDB fbDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_class);
        fbDB = new FeedbackDB(adminClass.this);
        photos = findViewById(R.id.button21);

        tv = findViewById(R.id.textView8);
        ArrayList<String> ar;
        if (fbDB.Getfeed()!= null) {
            ar = new ArrayList<>();
            ar = fbDB.Getfeed();
            int size = ar.size();
            //-------------------------
            for (int i = 0; i < ar.size(); i++) {
                int num = i+1;
                String str = ""+ tv.getText() + num +". "+ ar.get(i);
                tv.setText(str + ".\n ");
            }
        }


        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(getApplicationContext(), Pictures.class);
                startActivity(intent1);
            }
        });

    }

}