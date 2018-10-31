package com.example.patih.fitnessapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface excercisesDB_Dao {

    @Insert
     void insert(excercisesDB excercises);

    @Update
    void update(excercisesDB excercises);

    @Delete
    void delete(excercisesDB excercises);
}
