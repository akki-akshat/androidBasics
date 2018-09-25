package com.example.mchugh.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String toastMessage ="";
        switch (intentAction){
            case Intent.ACTION_POWER_CONNECTED:
                toastMessage="Power connected!";
                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                toastMessage="Power disconnected!";
                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
                break;
        }
    }

}