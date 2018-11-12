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
    void insert(Excercise_D excercise);

    @Update
    void update(Excercise_D excercise);

    @Delete
    void delete(Excercise_D excercise);

   // @Query("SELECT * FROM Calendar_D ORDER BY ID" )
   // LiveData<List<Calendar_D>> getAllCalendars();

   // @Query("DELETE FROM Calendar_D")
   // void deleteAllCalendar();

    //DAO for Calendar_D DB class
    //Missing query notations for SQL commands
    @Insert
    void insert(Calendar_D calendar);

    @Update
    void update(Calendar_D calendar);

    @Delete
    void delete(Calendar_D calendar);

  //  @Query("SELECT * FROM Excercise_D ORDER BY ID" )
  //  LiveData<List<Excercise_D>> getAllExcercises();

}
