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

    //DAO for excercises class
    //Missing query notations for SQL commands
    @Insert
    void insert(excercises excercises);

    @Update
    void update(excercises excercises);

    @Delete
    void delete(excercises excercises);

    @Query("SELECT * FROM calendar_table ORDER BY ID" )
    LiveData<List<calendar>> getAllCalendars();

    //DAO for calendar DB class
    //Missing query notations for SQL commands
    @Insert
    void insert(calendar calendar);

    @Update
    void update(calendar calendar);

    @Delete
    void delete(calendar calendar);

}
