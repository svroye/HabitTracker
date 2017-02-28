package com.example.android.habittracker;

import android.provider.BaseColumns;

/**
 * Created by Steven on 28/02/2017.
 */

public final class HabitTrackerContract {

    /**
     * private constructor; user should not create a variable of this class
     */
    private HabitTrackerContract() {

    }

    /**
     * class with the constants for the habits
     */
    public static final class HabitEntry implements BaseColumns {

        //name of the table
        public final static String TABLE_NAME = "HabitTracker";
        //to add id's to the rows
        public final static String _ID = BaseColumns._ID;
        //column with the name of the activity (=habit)
        public final static String COLUMN_ACTIVITY = "Activity";
        //number of days per week that the habit is performed
        public final static String COLUMN_DAYS = "Days";
        //number of hours per time that the activity is performed
        public final static String COLUMN_TIME = "Hours ";
    }
}
