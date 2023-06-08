package com.example.arabic.restaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FASTFOOD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastfood);
        Button b5 = findViewById(R.id.button5);
        b5.setOnClickListener(lis5);

        Button b6 = findViewById(R.id.button6);
        b6.setOnClickListener(lis6);

        Button b7 = findViewById(R.id.button7);
        b7.setOnClickListener(lis7);

        Button b8 = findViewById(R.id.button8);
        b8.setOnClickListener(lis8);

        Button b9 = findViewById(R.id.button9);
        b9.setOnClickListener(lis9);

        Button b10 = findViewById(R.id.button10);
        b10.setOnClickListener(lis10);
    }

    View.OnClickListener lis5 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button5);
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key","MCDONALDS");
            startActivity(intent);
        }
    };
    View.OnClickListener lis6 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button6);
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key","BBB");
            startActivity(intent);
        }

    };
    View.OnClickListener lis7 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button7);
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key","KFC");
            startActivity(intent);
        }

    };
    View.OnClickListener lis8 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button8);
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key","PIZZA HUT");
            startActivity(intent);
        }

    };

    View.OnClickListener lis9 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button9);
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key","BURGERIM");
            startActivity(intent);
        }

    };

    View.OnClickListener lis10 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView tv=(TextView)findViewById(R.id.button10);
            Intent intent = new Intent(getApplicationContext(),FastfoodInfo.class);
            intent.putExtra("key","CHICKERS");
            startActivity(intent);
        }

    };

}

