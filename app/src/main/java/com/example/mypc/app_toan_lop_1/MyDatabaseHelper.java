package com.example.mypc.app_toan_lop_1;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper{
    private static String DB_PATH =null;
    static final String KEY_ROWID = "_id";
    static final String KEY_NAME = "Baitoan";
    static final String KEY_DAPSO = "Dapan";
    static final String DATABASE_NAME = "database";
    static final String DATABASE_TABLE = "data";
    static final int DATABASE_VERSION = 2;

    private final Context myContext;
    private SQLiteDatabase myDataBase;

    public MyDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
        this.myContext = context;
        this.DB_PATH="/data/data/" +context.getPackageName() +"/"+"databases/";
        Log.e("Path1",DB_PATH);
    }
    public void createDataBase() throws IOException{
        boolean dbExist = checkDataBase();
        if(dbExist){
            //do nothing - database already exist
        }else{
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();
            try {
                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");
            }
        }
    }
    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch(SQLiteException e){
            //database does't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }
    private void copyDataBase() throws IOException{
        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
        // Path to the just created empty db
        String outFileName = DB_PATH + DATABASE_NAME;
        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);
        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public void openDatabase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DATABASE_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public ArrayList<String> getname() {
        ArrayList<String> arrname = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select Baitoan from data", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            arrname.add(res.getString(res.getColumnIndex(KEY_NAME)));
            res.moveToNext();
        }
        return arrname;
    }
    public ArrayList<Integer> getdapso() {
        ArrayList<Integer> dapso = new ArrayList<Integer>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select Dapan from data", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            dapso.add(res.getInt(res.getColumnIndex(KEY_DAPSO)));
            res.moveToNext();
        }
        return dapso;
    }
    public ArrayList<String> getnamenc() {
        ArrayList<String> arrname = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select baitoan from Toan_nang_cao", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            arrname.add(res.getString(res.getColumnIndex(KEY_NAME)));
            res.moveToNext();
        }
        return arrname;
    }
    public ArrayList<Integer> getdapsonc() {
        ArrayList<Integer> dapso = new ArrayList<Integer>();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select dapan from Toan_nang_cao", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            dapso.add(res.getInt(res.getColumnIndex(KEY_DAPSO)));
            res.moveToNext();
        }
        return dapso;
    }
}
