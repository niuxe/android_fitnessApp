package com.example.patih.fitnessapp.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface excercisesDB_Dao {

    //DAO for excercisesDB class
    //Missing query notations for SQL commands
    @Insert
     void insert(excercisesDB excercises);

    @Update
    void update(excercisesDB excercises);

    @Delete
    void delete(excercisesDB excercises);

    //DAO for calendar DB class
    //Missing query notations for SQL commands
    @Insert
    void insert(calendarDB calendar);

    @Update
    void update(calendarDB calendar);

    @Delete
    void delete(calendarDB calendar);

}
