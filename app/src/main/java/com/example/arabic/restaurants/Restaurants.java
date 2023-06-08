package com.example.arabic.restaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        Button b9 = findViewById(R.id.button9);
        b9.setOnClickListener(lis9);

        Button b10 = findViewById(R.id.button10);
        b10.setOnClickListener(lis10);

        Button b11 = findViewById(R.id.button11);
        b11.setOnClickListener(lis11);

        Button b12 = findViewById(R.id.button12);
        b12.setOnClickListener(lis12);

        Button b13 = findViewById(R.id.button13);
        b13.setOnClickListener(lis13);


        Button b14 = findViewById(R.id.button14);
        b14.setOnClickListener(lis14);


        Button b15 = findViewById(R.id.button15);
        b15.setOnClickListener(lis15);






    }

    View.OnClickListener lis9 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            TextView tv=(TextView)findViewById(R.id.button9);
            String aa=tv.getText().toString();
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key",aa);
            startActivity(intent);
        }
    };
    View.OnClickListener lis10 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button10);
            String aa=tv.getText().toString();
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key",aa);
            startActivity(intent);
        }

    };
    View.OnClickListener lis11 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button11);
            String aa=tv.getText().toString();
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key",aa);
            startActivity(intent);
        }

    };

    View.OnClickListener lis12 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button12);
            String aa=tv.getText().toString();
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key",aa);
            startActivity(intent);
        }

    };

    View.OnClickListener lis13 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button13);
            String aa=tv.getText().toString();
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key",aa);
            startActivity(intent);
        }

    };

    View.OnClickListener lis14 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button14);
            String aa=tv.getText().toString();
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key",aa);
            startActivity(intent);
        }

    };

    View.OnClickListener lis15 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button15);
            String aa=tv.getText().toString();
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key",aa);
            startActivity(intent);
        }

    };




}
