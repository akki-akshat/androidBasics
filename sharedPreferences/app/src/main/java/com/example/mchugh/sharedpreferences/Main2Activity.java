
package com.example.mchugh.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String rName,rEmail,rCity,rColor;
    TextView name,email,city,color;
    String userInputCity,userInputColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button rData = findViewById(R.id.r_data);
        Button navigateMaps = findViewById(R.id.maps);
        Button changeColor = findViewById(R.id.Colors);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        city = findViewById(R.id.city);
        color = findViewById(R.id.color);
        final CardView cardView = findViewById(R.id.cardView);
        rData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("userData",MODE_PRIVATE);
                rName = sharedPreferences.getString("name","N/A");
                rEmail = sharedPreferences.getString("email","N/A");
                rCity = sharedPreferences.getString("city","N/A");
                rColor = sharedPreferences.getString("color","N/A");
                userInputCity = rCity;
                userInputColor = rColor;
                name.setText(rName + "!");
                email.setText(rEmail);
                city.setText(rCity);
                color.setText(rColor);


            }
        });
        navigateMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String map = "http://maps.google.co.in/maps?q="+userInputCity;;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                        startActivity(intent);
            }
        });
        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setCardBackgroundColor(Color.parseColor(userInputColor));
                //                view.getRootView().setBackgroundColor((Color.parseColor(userInputColor)));
            }
        });
    }
}
