package com.example.mchugh.foodora;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class sideDish extends AppCompatActivity {

    GridView sideDishGridView,dessertsGridView;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_dish);

        SharedPreferences sharedPreferences = getSharedPreferences( "foodData", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        sideDishGridView = (GridView) findViewById(R.id.sideDishgridView);
        dessertsGridView = (GridView) findViewById(R.id.dessertsgridView);

        submit = findViewById(R.id.submit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sideDishes));

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.juicesIceCream));


        sideDishGridView.setAdapter(adapter);
        dessertsGridView.setAdapter(adapter2);

        sideDishGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),((TextView) view).getText(), Toast.LENGTH_LONG).show();
                editor.putString("sideDish", (String) ((TextView) view).getText());
            }


        });

        dessertsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),((TextView) view).getText(), Toast.LENGTH_LONG).show();
                editor.putString("desserts", (String) ((TextView) view).getText());

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.commit();
                Intent i = new Intent(getApplicationContext(),summary.class);
                startActivity(i);
            }
        });
    }



}