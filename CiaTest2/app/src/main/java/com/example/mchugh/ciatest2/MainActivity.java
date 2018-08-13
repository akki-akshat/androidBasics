package com.example.mchugh.ciatest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button login = findViewById(R.id.login);
        final Button register = findViewById(R.id.register);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),login.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent r = new Intent(getApplicationContext(),register.class);
                startActivity(r);
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Koramangala:
                Toast.makeText(this, "We are taking you to koramangala", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Ecity:
                Toast.makeText(this, "We are taking you to Electronic City!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.exit:
                System.exit(0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
