package com.example.mchugh.ciatest2;

import android.app.Notification;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ourProducts extends AppCompatActivity {
    int count=1;
    private NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_products);
        Button nextP = findViewById(R.id.nextP);
        Button prevP = findViewById(R.id.prevP);
        final Button addprod = findViewById(R.id.addProd);

        final BlankFragment prod1 = new BlankFragment();
        final BlankFragment2 prod2 = new BlankFragment2();
        final BlankFragment3 prod3 = new BlankFragment3();
        final BlankFragment4 prod4 = new BlankFragment4();

        notificationManager = NotificationManagerCompat.from(this);

        addprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1();
//                Toast.makeText(ourProducts.this, "Sucessfully added to Cart", Toast.LENGTH_SHORT).show();
            }
        });

        nextP.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                switch (count){
                case 1:
                    final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, prod2);
                    fragmentTransaction.commit();
                    count++;
                    break;
                case 2:

                    final FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fragment, prod3);
                    fragmentTransaction2.commit();
                    count++;
                    break;
                case 3:

                    final FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fragment, prod4);
                    fragmentTransaction3.commit();
                    count++;
                    break;
                case 4:
                    final FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.fragment, prod1);
                    fragmentTransaction4.commit();
                    count=1;
                    break;
                }
            }
        });
        prevP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (count){
                    case 1:
                        final FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction5.replace(R.id.fragment, prod4);
                        fragmentTransaction5.commit();
                        count=4;
                        break;
                    case 2:
                        final FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction6.replace(R.id.fragment, prod1);
                        fragmentTransaction6.commit();
                        count--;
                        break;
                    case 3:
                        final FragmentTransaction fragmentTransaction7 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction7.replace(R.id.fragment, prod2);
                        fragmentTransaction7.commit();
                        count--;
                        break;
                    case 4:
                        final FragmentTransaction fragmentTransaction8 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction8.replace(R.id.fragment, prod3);
                        fragmentTransaction8.commit();
                        count--;
                        break;
                }
            }
        });
    }
    public void sendOnChannel1() {
        Notification notification = new NotificationCompat.Builder(ourProducts.this, app.CHANNEL_1_ID)
                .setContentTitle("This is my notification title")
                .setContentText("This is my notification text")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();

        notificationManager.notify(1, notification);
    }
}
