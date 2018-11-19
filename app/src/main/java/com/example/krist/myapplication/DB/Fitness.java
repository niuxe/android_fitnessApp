package com.example.krist.myapplication.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "fitness_Table")
public class Fitness {

    @PrimaryKey(autoGenerate = true)

    private int ID;
    private String date;
    private String exerciseName;
    private int weight;
    private int sets;
    private int reps;

    public Fitness(String date, String exerciseName, int weight, int sets, int reps){
        this.date= date;
        this.exerciseName= exerciseName;
        this.weight =weight;
        this.sets=sets;
        this.reps=reps;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getWeight() {
        return weight;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }
}
