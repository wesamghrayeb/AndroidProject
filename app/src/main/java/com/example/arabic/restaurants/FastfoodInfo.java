package com.example.arabic.restaurants;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FastfoodInfo extends AppCompatActivity {
    TextView tv1, tv2;
    Button search,feedback, camera;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastfood_info);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView4);
        search = findViewById(R.id.button13);
        feedback = findViewById(R.id.button12);
        camera = findViewById(R.id.button17);
        dbHelper = new DBHelper(FastfoodInfo.this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("key")) {
                String ValueThatWasSent = (String) intent.getStringExtra("key");
                tv1.setText(ValueThatWasSent);
                tv2.setText(dbHelper.GetInformation(ValueThatWasSent).get(0));

            }
        }

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(getApplicationContext(), FeedbackActivity.class);
                intent1.putExtra("key", tv1.getText ().toString () );
                startActivity(intent1);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name = tv1.getText().toString();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, name + "Restaurant");
                startActivity(intent);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(getApplicationContext(), Camera.class);
                startActivity(intent1);
            }
        });
    }
}
