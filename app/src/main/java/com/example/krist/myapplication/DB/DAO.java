package com.example.krist.myapplication.DB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DAO {

    //DAO for Excercise class
    //Missing query notations for SQL commands
    @Insert
    void insert(Excercise Excercise);

    @Update
    void update(Excercise Excercise);

    @Delete
    void delete(Excercise Excercise);

    @Query("SELECT * FROM Calendar ORDER BY ID" )
    LiveData<List<Calendar>> getAllCalendars();

    @Query("DELETE FROM Calendar")
    void deleteAllCalendar();

    //DAO for Calendar DB class
    //Missing query notations for SQL commands
    @Insert
    void insert(Calendar Calendar);

    @Update
    void update(Calendar Calendar);

    @Delete
    void delete(Calendar Calendar);

    @Query("SELECT * FROM Excercise ORDER BY ID" )
    LiveData<List<Excercise>> getAllExcercises();

}
