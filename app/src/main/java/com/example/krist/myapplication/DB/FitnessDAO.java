package com.example.krist.myapplication.DB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface FitnessDAO {

    @Insert
    void insert(Fitness fitness);

    @Update
    void update(Fitness fitness);

    @Delete
    void delete(Fitness fitness);

    @Query("DELETE FROM fitness_Table")
    void deleteAllFitness();

    @Query("SELECT * FROM fitness_Table ORDER BY ID ASC")
    LiveData<List<Fitness>>getAllFitness();
}
