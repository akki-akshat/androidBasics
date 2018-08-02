package com.example.mchugh.inputcontrolsnew;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        listenerForRatingBar();
        Button nextRating = findViewById(R.id.nextRating);
        nextRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main5Activity.class);
                startActivity(i);
            }
        });
    }
    public void listenerForRatingBar() {
        RatingBar rating_b = findViewById(R.id.ratingBar);
        final TextView rating_text = findViewById(R.id.ratingText);
        rating_b.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float ratingValue, boolean b) {
                rating_text.setText(String.valueOf(ratingValue));
            }
        });
    }
}
