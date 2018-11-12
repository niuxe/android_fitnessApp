package com.example.krist.myapplication.DB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = Calendar_D.class, version =1)
public abstract class CalendarDatabase extends RoomDatabase {

    private static CalendarDatabase instance;

    public abstract DAO excerciseDAO();

    public static synchronized CalendarDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CalendarDatabase.class, "calendar_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(calendarCallback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback calendarCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateCalendarDBAsyncTask(instance).execute();
        }

    };
    private static class populateCalendarDBAsyncTask extends AsyncTask<Void, Void,Void>{
        private DAO calendarDAO;
        private populateCalendarDBAsyncTask(CalendarDatabase databaseCAL){
            calendarDAO = databaseCAL.excerciseDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            calendarDAO.insert(new Calendar_D("date1","excercise name 1" ,10,5));
            calendarDAO.insert(new Calendar_D("date2","excercise name 2" ,11,6));
            calendarDAO.insert(new Calendar_D("date3","excercise name 3" ,12,7));

            return null;
        }
    }
}
