package com.example.mchugh.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,email,city,color;
    String inputName,inputEmail,inputCity,inputColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.userEmail);
        city = findViewById(R.id.city);
        color = findViewById(R.id.color);

        Button submit = findViewById(R.id.submit);
        Button next = findViewById(R.id.next);
        Button red,blue,green,black;

        red = findViewById(R.id.red);
        blue = findViewById(R.id.blue);
        green = findViewById(R.id.green);
        black = findViewById(R.id.black);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color.setText("#CC0000");
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color.setText("#303F9F");
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color.setText("#669900");
            }
        });
        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color.setText("#000000");
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputName = name.getText().toString();
                inputEmail = email.getText().toString();
                inputCity = city.getText().toString();
                inputColor = color.getText().toString();


                SharedPreferences sharedPreferences = getSharedPreferences( "userData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("name",inputName);
                editor.putString("email",inputEmail);
                editor.putString("city",inputCity);
                editor.putString("color",inputColor);

                editor.commit();

                Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });
    }
}
