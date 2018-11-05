package com.example.krist.myapplication.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "calendar_Table")
public class calendar {

    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String date;
    private String excerciseName;
    private int weight;
    private int sets;

    public calendar(int ID, String date, String excerciseName, int weight, int sets){
        this.ID=ID;
        this.date =date;
        this.excerciseName =excerciseName;
        this.weight=weight;
        this.sets=sets;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setExcerciseName(String excerciseName) {
        this.excerciseName = excerciseName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public String getExcerciseName() {
        return excerciseName;
    }

    public String getDate() {
        return date;
    }

    public int getSets() {
        return sets;
    }

    public int getWeight() {
        return weight;
    }
}

