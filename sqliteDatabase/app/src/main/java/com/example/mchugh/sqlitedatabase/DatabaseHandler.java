package com.example.mchugh.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final String name = "sbiBank";
    private static final int version = 1;
    private static final String TABLE_NAME = "savingsAccount";

    public DatabaseHandler(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + "acc_No INTEGER PRIMARY KEY, acc_Holder TEXT, opening_Balance FLOAT)";
        db.execSQL(CREATE_ITEM_TABLE);
    }

    public boolean insertAccountDetails(int accNum, String accountHolder, Float openBal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("acc_No",accNum);
        contentValues.put("acc_Holder",accountHolder);
        contentValues.put("opening_Balance",openBal);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1){
            return false;
        }else {
            return true;
        }

    }

    public StringBuffer fetchAccountDetails() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resultSet = db.rawQuery("Select * FROM savingsAccount", null);

        StringBuffer buffer = new StringBuffer();
        while (resultSet.moveToNext()){
            buffer.append("Account Number :" + resultSet.getInt(0) + "\n");
            buffer.append("Account Holder's Name :" + resultSet.getString(1) + "\n");
            buffer.append("Opening Balance : " + resultSet.getFloat(2) + "\n\n\n");
        }
        return buffer;

    }

    public boolean updateData(int accNum, String accountHolder, Float openBal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("acc_No",accNum);
        contentValues.put("acc_Holder",accountHolder);
        contentValues.put("opening_Balance",openBal);

        db.update(TABLE_NAME,contentValues,"acc_No = ?",new String[] {Integer.toString(accNum)});
        return true;
    }

    public Integer deleteData (Integer accNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME,"acc_No = ?",new String[] {Integer.toString(accNo)});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
}
