package com.example.mchugh.notificationnew;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

public class    MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notifyBTN = findViewById(R.id.buttonNotify);
        notificationManager = NotificationManagerCompat.from(this);

        notifyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1();
            }
        });
    }
    public void sendOnChannel1() {
        Notification notification = new NotificationCompat.Builder(MainActivity.this, app.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle("This is my notification title")
                .setContentText("This is my notification text")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManager.notify(1, notification);
    }
}
