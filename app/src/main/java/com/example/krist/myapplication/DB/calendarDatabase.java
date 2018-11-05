package com.example.krist.myapplication.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = calendar.class, version =1)
public abstract class calendarDatabase extends RoomDatabase {

    private static calendarDatabase instance;

    public abstract DAO excerciseDAO();

    public static synchronized calendarDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    calendarDatabase.class, "calendar_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
