package com.example.mchugh.ciatest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText uname,pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = findViewById(R.id.userName);
        pass = findViewById(R.id.pswd);
        login = findViewById(R.id.loginNow);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=uname.getText().toString();
                String pswd=pass.getText().toString();

                if(user.equals("admin") && pswd.equals("password")){
                    startActivity(new Intent(getApplicationContext(),ourProducts.class));
                    finish();
                }
                else {
                    Toast.makeText(login.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
