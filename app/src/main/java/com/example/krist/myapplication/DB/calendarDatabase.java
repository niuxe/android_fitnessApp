package com.example.krist.myapplication.DB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = Calendar.class, version =1)
public abstract class calendarDatabase extends RoomDatabase {

    private static calendarDatabase instance;

    public abstract DAO excerciseDAO();

    public static synchronized calendarDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    calendarDatabase.class, "calendar_database")
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
        private populateCalendarDBAsyncTask(calendarDatabase databaseCAL){
            calendarDAO = databaseCAL.excerciseDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            calendarDAO.insert(new Calendar("date1","excercise name 1" ,10,5));
            calendarDAO.insert(new Calendar("date2","excercise name 2" ,11,6));
            calendarDAO.insert(new Calendar("date3","excercise name 3" ,12,7));

            return null;
        }
    }
}
