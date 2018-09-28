package com.example.mchugh.foodora;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class finalScreen extends AppCompatActivity {

    Button pay,reset;
    Integer payAmount = 0;
    private NotificationManagerCompat notificationManager;

    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";
    private void createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID,"Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is channel 1");


            NotificationManager nManager = getSystemService(NotificationManager.class);
            nManager.createNotificationChannel(channel1);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        payAmount = getIntent().getExtras().getInt("totalAmount");
        notificationManager = NotificationManagerCompat.from(this);

        pay = findViewById(R.id.pay);
        reset = findViewById(R.id.resetOrder);

        SharedPreferences sharedPreferences = getSharedPreferences( "foodData", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();


        pay.setText("Pay ₹" + payAmount);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_1_ID)
                        .setContentTitle("This is my notification title")
                        .setContentText("This is my notification text")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

                notificationManager.notify(1, notification);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        createNotificationChannels();


    }
//    public void sendOnChannel1() {
//        Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_1_ID)
//                .setContentTitle("This is my notification title")
//                .setContentText("This is my notification text")
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
//
//        notificationManager.notify(1, notification);
//    }




}
