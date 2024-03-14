package com.example.labmanagement;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Databasehelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Labdetails.db";
    public static final String TABLE_NAME = "LoginDetails";
    public static final String ID = "ID";
    public static final String UNAME = "UNAME";
    public static final String EMAILS = "EMAILS";
    public static final String PASSD = "PASSD";


    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT,EMAILS TEXT,PASSD TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean UserData(String name,String email,String pass) {
        boolean res;
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UNAME,name);
        contentValues.put(EMAILS,email);
        contentValues.put(PASSD,pass);
        long result = db1.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            res=false;
        else
            res=true;
        //db.insert(TABLE_NAME,null,contentValues);
        db1.close();
        return  res;
    }
    public Cursor check( String unames,String mailid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ///String query = "Select * FROM " + TABLE_NAME + " WHERE " + EMAILS + " =  \"" + uname + "\" ";
        String query="Select * from LoginDetails where UNAME = '"+unames+"' and EMAILS='" + mailid+"'";
        Cursor res= db.rawQuery(query,null);
        return res;
    }

    public Cursor checklogin( String uname,String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        //String query = "Select * FROM " + TABLE_NAME + " WHERE " + EMAILS + " =  \"" + uname + "\" ";
        String qu="Select * from LoginDetails where EMAILS= '" +uname+"' and PASSD='" + pass+"'";
        Cursor res= db.rawQuery(qu,null);
        return res;
    }
}
