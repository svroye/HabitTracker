package com.example.android.habittracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import static android.R.attr.version;

/**
 * Created by Steven on 28/02/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    //name and version number of the database
    public static final String DATABASE_NAME = "habittracker.db" ;
    public static final int DATABASE_VERSION = 1;

    //statement for creating a new table in the database
    private static final String CREATE_SQL = "CREATE TABLE " + HabitTrackerContract.HabitEntry.TABLE_NAME
            + "( " + HabitTrackerContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + HabitTrackerContract.HabitEntry.COLUMN_ACTIVITY + " TEXT, "
            + HabitTrackerContract.HabitEntry.COLUMN_DAYS + " INTEGER, "
            + HabitTrackerContract.HabitEntry.COLUMN_TIME + "REAL);";

    //statement for deleting a table in the databse
    private static final String DELETE_SQL = "DROP TABLE IF EXISTS "  + HabitTrackerContract.HabitEntry.TABLE_NAME +";";

    //constructor for the class
    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     *  creates a table in a database, with the table name and column names specified in the
     *  HabitTrackerContract.HabitEntry class
     * @param db database to which the table has to be added
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SQL);
    }

    /**
     * deletes the existing table and creates a new one
     * @param db database on which the update has to be performed
     * @param oldVersion oldVersion of the table
     * @param newVersion newVersion of the table
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_SQL);
        onCreate(db);
    }
}
