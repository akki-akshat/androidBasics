package com.example.mchugh.inputcontrolsnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final Switch switch1 = findViewById(R.id.switch1);
        Button internNext = findViewById(R.id.internNext);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if( b==true ){
                    switch1.setText("Yes");
                }else{
                    switch1.setText("No");
                }
            }
        });

        internNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switch1.getText()=="Yes")
                {
                    Intent i = new Intent(getApplicationContext(),Main4Activity.class);
                    startActivity(i);
                }
            }
        });
    }
}
