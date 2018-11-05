package com.example.krist.myapplication.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "calendar_Table")
public class Calendar {

    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String date;
    private String excerciseName;
    private int weight;
    private int sets;

    public Calendar(String date, String excerciseName, int weight, int sets) {
        this.date = date;
        this.excerciseName = excerciseName;
        this.weight = weight;
        this.sets = sets;
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

    public String getExcerciseName() {
        return excerciseName;
    }

    public int getWeight() {
        return weight;
    }

    public int getSets() {
        return sets;
    }
}

