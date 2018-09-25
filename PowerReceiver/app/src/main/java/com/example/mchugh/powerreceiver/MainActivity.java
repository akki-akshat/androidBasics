package com.example.mchugh.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mchugh.powerreceiver.R;

public class MainActivity extends AppCompatActivity {
    IntentFilter filter;
    BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter = new IntentFilter();
        // specify the action to which receiver will listen
        filter.addAction("com.local.receiver");
        registerReceiver(receiver,filter);

        Intent intent=new Intent("com.local.receiver");
        sendBroadcast(intent);
    }
}
