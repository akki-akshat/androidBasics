package com.example.mchugh.foodora;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button nextScreen,veg,nonVeg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences( "foodData", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        nextScreen = findViewById(R.id.nextScreen);
        veg = findViewById(R.id.vegFood);
        nonVeg = findViewById(R.id.nonVegFood);

        nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),mainCourse.class);
                startActivity(i);
            }
        });

        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Veg", Toast.LENGTH_SHORT).show();
                editor.putString("foodType","Veg");
                editor.commit();
                nonVeg.setEnabled(false);
            }
        });

        nonVeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Non-Veg", Toast.LENGTH_SHORT).show();
                editor.putString("foodType","NonVeg");
                editor.commit();
                veg.setEnabled(false);
            }
        });
    }
}
