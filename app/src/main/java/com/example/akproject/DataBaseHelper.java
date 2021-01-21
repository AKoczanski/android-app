package com.example.akproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "activities_table";
    private static final String firstColumn = "id";
    private static final String DATABASE_NAME = "Todo.db";
    private static final String secondColumn = "name";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + firstColumn + " INTEGER PRIMARY KEY AUTOINCREMENT, " + secondColumn + " TEXT);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(secondColumn, item);

        Log.d(TAG, "addData: Adding " + item + " to: " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor date = db.rawQuery(query, null);
        return date;
    }

    public Cursor getId(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + firstColumn + " FROM " + TABLE_NAME + " WHERE " + secondColumn + " = '" +name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateData(String name, int id, String oldName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + secondColumn + " = '" +name + "' WHERE " + firstColumn + " = '" + id + "'" + " AND " + secondColumn + " = '" + oldName + "'";
        Log.d(TAG, "Update: " + query);
        Log.d(TAG, "Set to: " + name);
        sqLiteDatabase.execSQL(query);
    }

    public void deleteData(int id, String name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + firstColumn + " = '" + id + "'" + " AND " +secondColumn + " = '" + name + "'";
        Log.d(TAG, "Deleted query: " + query);
        Log.d(TAG, "Deleted data: " + name);
        sqLiteDatabase.execSQL(query);
    }
}
