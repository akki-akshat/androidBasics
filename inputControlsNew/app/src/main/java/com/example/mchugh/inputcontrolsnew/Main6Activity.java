package com.example.mchugh.inputcontrolsnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main6Activity extends AppCompatActivity {
    TimePicker timePicker;
    String post="AM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        timePicker = (TimePicker) findViewById(R.id.timePicker);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                if(i>12){
                    i = i -12;
                    post = "PM";
                }else {
                    post = "AM";
                }
                Toast.makeText(Main6Activity.this, "" + i + ":" + i1 + " " + post, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
