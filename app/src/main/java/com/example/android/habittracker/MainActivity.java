package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    HabitDbHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create instance of the helper class
        myHelper = new HabitDbHelper(this);
    }

    /**
     * add an habit to the table HabitTracker of the database habittracker, which contains all
     * habits of the user, together with the number of days in the week that the habit is exercised
     * and the hours per exercise session
     * example : if the user goes for a 30 min run 3 times a week, the activity name would be
     * "running", the days would be 3 and the hours would be 0.5
     * @param activity : activity name that has to be added to the table
     * @param days : number of days in the week that the activity is performed
     * @param hours : hours per time that the activity is performed
     */
    public void addHabit(String activity, int days, float hours){
        //create database object to write data to
        SQLiteDatabase db = myHelper.getReadableDatabase();

        //create ContentValues to store the values and add all of this as a new row in the database
        ContentValues values = new ContentValues();
        values.put(HabitTrackerContract.HabitEntry.COLUMN_ACTIVITY,activity);
        values.put(HabitTrackerContract.HabitEntry.COLUMN_DAYS,days);
        values.put(HabitTrackerContract.HabitEntry.COLUMN_TIME,hours);
        long newId = db.insert(HabitTrackerContract.HabitEntry.TABLE_NAME,null,values);
    }


    /**
     * reads the habit on a certain position of the table HabitTracker
     * @param position : row index of the habit to read
     * @return : Cursor object containing the row and all the columns of the table
     */
    public Cursor readHabit(int position){
        //get database object to read the values
        SQLiteDatabase db = myHelper.getReadableDatabase();
        String [] selAr= {String.valueOf(position)};

        //read all info
        Cursor c = db.query(HabitTrackerContract.HabitEntry.TABLE_NAME,null,
                HabitTrackerContract.HabitEntry._ID +"=?",selAr,null,null,null);

        return c;
    }

}
