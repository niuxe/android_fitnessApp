package com.example.krist.myapplication.DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

@Dao
public interface DAO {

    //DAO for Excercise_D class
    //Missing query notations for SQL commands
    @Insert
    void insert(Excercise_D Excercise);

    @Update
    void update(Excercise_D Excercise);

    @Delete
    void delete(Excercise_D Excercise);

    // @Query("SELECT * FROM Calendar_D ORDER BY ID" )
    // LiveData<List<Calendar_D>> getAllCalendars();

    // @Query("DELETE FROM Calendar_D")
    //void deleteAllCalendar();

    //DAO for Calendar_D DB class
    //Missing query notations for SQL commands
    @Insert
    void insert(Calendar_D Calendar);

    @Update
    void update(Calendar_D Calendar);

    @Delete
    void delete(Calendar_D Calendar);

    // @Query("SELECT * FROM Excercise_D ORDER BY ID" )
    // LiveData<List<Excercise_D>> getAllExcercises();

}
