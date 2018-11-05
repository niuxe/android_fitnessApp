package com.example.krist.myapplication.DB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = Excercise.class, version =1)
public abstract class excercisesDatabase extends RoomDatabase {

    private static excercisesDatabase instance;

    public abstract DAO excerciseDAO();

    public static synchronized excercisesDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    excercisesDatabase.class, "excercise_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback excercisesCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateExcercisesDBAsyncTask(instance).execute();
        }
    };

   private static class populateExcercisesDBAsyncTask extends AsyncTask<Void, Void, Void>{
    private DAO excercisesDAO;
    private populateExcercisesDBAsyncTask(excercisesDatabase databaseEX){
        excercisesDAO = databaseEX.excerciseDAO();
    }

       @Override
       protected Void doInBackground(Void... voids) {
          excercisesDAO.insert(new Excercise(1,"bench press","top"));
    return null;
    }
   }
}
