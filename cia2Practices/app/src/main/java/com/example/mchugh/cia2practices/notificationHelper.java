package com.example.mchugh.cia2practices;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;

class notificationHelper extends Application {


    @RequiresApi(api = Build.VERSION_CODES.O)
    public notificationHelper(Context context) {
        NotificationChannel showNotification =
                new NotificationChannel(
                  "myChannelID03","myNotificationName", NotificationManager.IMPORTANCE_HIGH
                );

        showNotification.setShowBadge(true);
        showNotification.setLightColor(Color.BLUE);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(showNotification);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getShowNotification(){
        return new Notification.Builder(notificationHelper.this,"myChannelID03")
                .setContentTitle("Yeh hai mera notification")
                .setContentText("Yeh uska patla body");
    }
}
