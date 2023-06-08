package com.example.arabic.restaurants;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {
    Button send;
    EditText feed;
    FeedbackDB Feedbackdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        send = findViewById(R.id.button14);
        feed = findViewById(R.id.editText);

        Feedbackdb = new FeedbackDB(FeedbackActivity.this){
            @Override
            public void onCreate(SQLiteDatabase db) {
                super.onCreate(db);
            }
        };
        Intent intent = getIntent ();
        if (intent != null) {
            if (intent.hasExtra("key")) {
                String ValueThatWasSent = (String) intent.getStringExtra("key");
                feed.setText (  ValueThatWasSent + ": " );
            }
        }
        send.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v)
            {
                String fb= feed.getText().toString();
                if(fb.isEmpty())
                {
                    Toast.makeText(FeedbackActivity.this, "Please Write Feedback!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Feedbackdb.AddFeed(fb);

                NotificationChannel channel = new NotificationChannel("channel01", "name",
                        NotificationManager.IMPORTANCE_HIGH);   // for heads-up notifications
                channel.setDescription("description");

// Register channel with system
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);

                Notification notification = new NotificationCompat.Builder(FeedbackActivity.this, "channel01")
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("FEEDBACK")
                        .setContentText("Feedback Sent Thank YOU!!")
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setPriority( NotificationCompat.PRIORITY_HIGH)   // heads-up
                        .build();

                NotificationManagerCompat notificationManager1 = NotificationManagerCompat.from(FeedbackActivity.this);
                notificationManager1.notify(0, notification);
            }
        });


    }
}