package com.example.krist.myapplication.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = excercises.class, version =1)
public abstract class excercisesDatabase extends RoomDatabase {

    private static excerciseDatabase instance;

    public abstract DAO excerciseDAO();

    public static synchronized excerciseDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    excerciseDatabase.class, "excercise_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
