    package com.example.mchugh.foodora;

    import android.content.Context;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.ListView;
    import android.widget.TextView;
    import android.widget.Toast;

    public class mainCourse extends AppCompatActivity {

        ListView listView;
        TextView textView;
        String[] listItem;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_course);

            SharedPreferences sharedPreferences = getSharedPreferences( "foodData", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = sharedPreferences.edit();


            listView=findViewById(R.id.listview);
            textView=(TextView)findViewById(R.id.myListTextView);

            if(sharedPreferences.getString("foodType","N/A") == "Veg"){
                listItem = getResources().getStringArray(R.array.vegFood);
            }else if(sharedPreferences.getString("foodType","N/A") == "NonVeg"){
                listItem = getResources().getStringArray(R.array.nonVegFood);
            }

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    String value=adapter.getItem(position);
                    editor.putString("MainCourse",value);
                    editor.commit();
                    Intent i = new Intent(getApplicationContext(),sideDish.class);
                    startActivity(i);
                }
            });

        }
    }
