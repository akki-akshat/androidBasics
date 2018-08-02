package com.example.mchugh.cia2practices;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private notificationHelper mNotificationHelper;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notify = findViewById(R.id.Notify);
        mNotificationHelper = new notificationHelper(this);
        notify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mNotificationHelper.getShowNotification();
            }
        });

    }

}
