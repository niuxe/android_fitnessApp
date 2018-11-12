package com.example.krist.myapplication.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = Fitness.class,version = 1)
public abstract class FitnessDB extends RoomDatabase {

    private static FitnessDB instance;

    public abstract FitnessDAO fitnessDao();

    public static synchronized FitnessDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FitnessDB.class,"fitness_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
