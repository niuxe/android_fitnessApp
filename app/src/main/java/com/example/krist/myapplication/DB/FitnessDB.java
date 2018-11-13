package com.example.krist.myapplication.DB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


//exportSchema = false -> ask Kasper tmrw

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
            fitnessDao.insert(new FitnessDB("12/05/2018","push-ups",12,2,2));
            fitnessDao.insert(new FitnessDB("12/05/2018","push-ups",12,2,2));
            fitnessDao.insert(new FitnessDB("12/05/2018","push-ups",12,2,2));

            return null;
        }
    }
}
