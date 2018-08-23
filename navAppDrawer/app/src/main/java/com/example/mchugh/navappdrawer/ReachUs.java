package com.example.mchugh.navappdrawer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class ReachUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reach_us);

        Button callUs = findViewById(R.id.callUs);
        Button emailUs = findViewById(R.id.emailUs);
        switch (getIntent().getStringExtra("EXTRA")){
            case "openFragment":

                emailUs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setData(Uri.parse("email"));
                        String to[] = {"yulomessenger@gmail.com"};
                        i.putExtra(Intent.EXTRA_EMAIL,to);
                        i.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
                        i.putExtra(Intent.EXTRA_TEXT,"This is the text that no one reads");
                        i.setType("message/rfc822");
                        Intent chooser = Intent.createChooser(i,"Launch Email");
                        startActivity(chooser);
                    }
                });
                callUs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_DIAL);
                        i.setData(Uri.parse("tel:7359880791"));
                        startActivity(i);
                    }
                });
                final writeUs writeFragment = new writeUs();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentWriteUs, writeFragment).commit();
                break;
            case "dontOpenFragment":
                emailUs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setData(Uri.parse("email"));
                        String to[] = {"yulomessenger@gmail.com"};
                        i.putExtra(Intent.EXTRA_EMAIL,to);
                        i.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
                        i.putExtra(Intent.EXTRA_TEXT,"This is the text that no one reads");
                        i.setType("message/rfc822");
                        Intent chooser = Intent.createChooser(i,"Launch Email");
                        startActivity(chooser);
                    }
                });
                callUs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_DIAL);
                        i.setData(Uri.parse("tel:7359880791"));
                        startActivity(i);
                    }
                });
                break;
        }


    }
}
