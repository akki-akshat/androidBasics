package com.example.mchugh.foodora;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class summary extends AppCompatActivity {

    String MainCourse,sideDish,Desserts;
    TextView sumMainCourse,sumSideDish,sumDesserts,totalVal;
    Integer amountMainCourse,amountSideDish,amountSideDesserts,totalAmount;
    Button placeOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        amountMainCourse=0;

        SharedPreferences sharedPreferences = getSharedPreferences( "foodData", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        MainCourse = sharedPreferences.getString("MainCourse","N/A");
        sideDish = sharedPreferences.getString("sideDish","N/A");
        Desserts = sharedPreferences.getString("desserts","N/A");

        sumMainCourse = findViewById(R.id.sumMain);
        sumSideDish = findViewById(R.id.sumSide);
        sumDesserts = findViewById(R.id.sumDesserts);
        totalVal = findViewById(R.id.totalVal);
        placeOrder = findViewById(R.id.placeOrder);

        sumMainCourse.setText(MainCourse);
        sumSideDish.setText(sideDish);
        sumDesserts.setText(Desserts);

        if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[0])){
            amountMainCourse = 150;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[1])){
            amountMainCourse = 159;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[2])){
            amountMainCourse = 129;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[3])){
            amountMainCourse = 70;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[4])){
            amountMainCourse = 250;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[5])){
            amountMainCourse = 180;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[6])){
            amountMainCourse = 120;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[7])){
            amountMainCourse = 50;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[8])){
            amountMainCourse = 30;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.vegFood)[9])){
            amountMainCourse = 90;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.nonVegFood)[0])){
            amountMainCourse = 150;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.nonVegFood)[1])){
            amountMainCourse = 159;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.nonVegFood)[2])){
            amountMainCourse = 129;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.nonVegFood)[3])){
            amountMainCourse = 70;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.nonVegFood)[4])){
            amountMainCourse = 250;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.nonVegFood)[5])){
            amountMainCourse = 180;
        }else if(MainCourse.toString().equals(getResources().getStringArray(R.array.nonVegFood)[6])){
            amountMainCourse = 120;
        }


        if(sideDish.toString().equals(getResources().getStringArray(R.array.sideDishes)[0])){
            amountSideDish = 150;
        }else if(sideDish.toString().equals(getResources().getStringArray(R.array.sideDishes)[1])){
            amountSideDish = 159;
        }else if(sideDish.toString().equals(getResources().getStringArray(R.array.sideDishes)[2])){
            amountSideDish = 129;
        }else if(sideDish.toString().equals(getResources().getStringArray(R.array.sideDishes)[3])){
            amountSideDish = 70;
        }else if(sideDish.toString().equals(getResources().getStringArray(R.array.sideDishes)[4])){
            amountSideDish = 250;
        }else if(sideDish.toString().equals(getResources().getStringArray(R.array.sideDishes)[5])){
            amountSideDish = 180;
        }

        if(Desserts.toString().equals(getResources().getStringArray(R.array.juicesIceCream)[0])){
            amountSideDesserts = 40;
        }else if(Desserts.toString().equals(getResources().getStringArray(R.array.juicesIceCream)[1])){
            amountSideDesserts = 20;
        }else if(Desserts.toString().equals(getResources().getStringArray(R.array.juicesIceCream)[2])){
            amountSideDesserts = 10;
        }else if(Desserts.toString().equals(getResources().getStringArray(R.array.juicesIceCream)[3])){
            amountSideDesserts = 20;
        }else if(Desserts.toString().equals(getResources().getStringArray(R.array.juicesIceCream)[4])){
            amountSideDesserts = 60;
        }

        totalAmount = amountMainCourse + amountSideDish + amountSideDesserts;

        totalVal.setText("₹"+Integer.toString(totalAmount));

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),finalScreen.class);
                i.putExtra("totalAmount", totalAmount);
                startActivity(i);
            }
        });



    }


}
