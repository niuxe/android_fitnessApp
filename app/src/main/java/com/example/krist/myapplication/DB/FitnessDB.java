package com.example.krist.myapplication.DB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = Fitness.class,version = 1, exportSchema = false)
public abstract class FitnessDB extends RoomDatabase {

    private static FitnessDB instance;

    public abstract FitnessDAO fitnessDao();

    public static synchronized FitnessDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FitnessDB.class,"fitness_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(fitnessCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback fitnessCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateFitnessDBAsyncTask(instance).execute();
        }

    };
    private static class populateFitnessDBAsyncTask extends AsyncTask<Void, Void,Void> {
        private FitnessDAO fitnessDao;
        private populateFitnessDBAsyncTask(FitnessDB fitnessDb){
            fitnessDao = fitnessDb.fitnessDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            fitnessDao.insert(new Fitness("12/11/2018","Deadlift",120,4,2));
            fitnessDao.insert(new Fitness("19/11/2018","Deadlift",120,4,2));
            fitnessDao.insert(new Fitness("26/11/2018","Deadlift",120,4,2));

            fitnessDao.insert(new Fitness("11/11/2018","Bench Press",90,5,4));
            fitnessDao.insert(new Fitness("18/11/2018","Bench Press",90,5,4));
            fitnessDao.insert(new Fitness("25/11/2018","Bench Press",90,5,4));

            fitnessDao.insert(new Fitness("10/11/2018","Squat",70,4,8));
            fitnessDao.insert(new Fitness("17/11/2018","Squat",70,4,8));
            fitnessDao.insert(new Fitness("24/11/2018","Squat",70,4,8));

            return null;
        }
    }
}
