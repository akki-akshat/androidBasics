package com.example.mchugh.inputcontrolsnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Button nextDate = findViewById(R.id.nextDateBtn);
        DatePicker datePicker = findViewById(R.id.timePicker);
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(),datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear(),Toast.LENGTH_SHORT).show();
            }
        });
        nextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent is = new Intent(getApplicationContext(),Main6Activity.class);
                startActivity(is);
            }
        });


    }
}
