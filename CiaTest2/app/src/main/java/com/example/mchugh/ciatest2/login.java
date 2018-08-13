package com.example.mchugh.ciatest2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    String username,password;
    String correctUsr = "admin";
    String correctPwd = "password";
//    EditText usr = findViewById(R.id.userName);
//    EditText pwd = findViewById(R.id.pswd);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button Login = findViewById(R.id.loginNow);
        Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent stationeryProducts = new Intent(getApplicationContext(), com.example.mchugh.ciatest2.stationeryProducts.class);
                startActivity(stationeryProducts);
//                username = usr.getText().toString();
//                password = pwd.getText().toString();
//                if((username.equals(correctUsr)) && (password.equals(correctPwd))){
//                    Intent stationeryProducts = new Intent(getApplicationContext(), com.example.mchugh.ciatest2.stationeryProducts.class);
//                    startActivity(stationeryProducts);
//                }else {
//                    Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

}
