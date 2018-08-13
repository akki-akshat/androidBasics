package com.example.mchugh.ciatest2;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class stationeryProducts extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    CheckBox pencil,eraser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stationery_products);

        pencil = findViewById(R.id.pencil);
        eraser = findViewById(R.id.eraser);


        pencil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(stationeryProducts.this, "tjisd", Toast.LENGTH_SHORT).show();
//                sendOnChannel1();
                    }
        });

        eraser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
        }
        public void sendOnChannel1 () {
            notificationManager = NotificationManagerCompat.from(this);
            Notification notification = new NotificationCompat.Builder(stationeryProducts.this, com.example.mchugh.ciatest2.notification.CHANNEL_1_ID)
                    .setContentTitle("This is my notification title")
                    .setContentText("This is my notification text")
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
            notificationManager.notify(1, notification);
        }
    }