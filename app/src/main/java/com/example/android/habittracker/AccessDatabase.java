package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Steven on 28/02/2017.
 */

public class AccessDatabase {

    Context context;

    //create instance of the helper class
    HabitDbHelper myHelper = new HabitDbHelper(context);




    public void addHabit(String activity, int days, int hours){
        //create database object to write data to
        SQLiteDatabase db = myHelper.getWritableDatabase();

        //create ContentValues to store the values and add all of this as a new row in the database
        ContentValues values = new ContentValues();
        values.put(HabitTrackerContract.HabitEntry.COLUMN_ACTIVITY,activity);
        values.put(HabitTrackerContract.HabitEntry.COLUMN_DAYS,days);
        values.put(HabitTrackerContract.HabitEntry.COLUMN_TIME,hours);
        long newId = db.insert(HabitTrackerContract.HabitEntry.TABLE_NAME,null,values);
    }

    public Cursor readHabit(int position){
        //get database object to read the values
        SQLiteDatabase db = myHelper.getReadableDatabase();

        //read all info
        Cursor c = db.query(HabitTrackerContract.HabitEntry.TABLE_NAME,null,null,null,null,null,null);
        return c;
    }

}
