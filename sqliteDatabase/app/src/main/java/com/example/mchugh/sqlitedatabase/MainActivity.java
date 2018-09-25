package com.example.mchugh.sqlitedatabase;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHandler myDb;
    Button addAccount,getData,deleteData,updateData;
    StringBuffer dataRetrieved;
    TextInputLayout accNo,accName,openBal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHandler(this);

//        InputFields
        accNo=findViewById(R.id.ac_No);
        accName=findViewById(R.id.acc_Name);
        openBal=findViewById(R.id.opBal);

//        Buttons
        addAccount=findViewById(R.id.add_account);
        getData=findViewById(R.id.getData);
        deleteData=findViewById(R.id.deleteData);
        updateData=findViewById(R.id.updateData);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataRetrieved = myDb.fetchAccountDetails();
                showMessage("Account Details", dataRetrieved.toString());
            }
        });

        addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(accNo.getEditText().getText().toString().isEmpty()){
                    accNo.setError("Please Enter the Account Number");
                    accNo.requestFocus();
                }else if(accName.getEditText().getText().toString().isEmpty()) {
                    accName.setError("Please Enter the Account Holder's Name");
                    accName.requestFocus();
                }
                boolean inserted = myDb.insertAccountDetails(Integer.parseInt(accNo.getEditText().getText().toString()),accName.getEditText().getText().toString(),Float.parseFloat(openBal.getEditText().getText().toString()));

                if(inserted==true) {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Failed to Insert Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(Integer.parseInt(accNo.getEditText().getText().toString()));
                if(deletedRows>0){
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Failed to Delete Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = myDb.updateData(Integer.parseInt(accNo.getEditText().getText().toString()),accName.getEditText().getText().toString(),Float.parseFloat(openBal.getEditText().getText().toString()));
                if(isUpdated==true){
                    Toast.makeText(MainActivity.this, "Successfully Updated Data", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Failed To Update Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showMessage(String title,String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }




}
