package com.example.patih.fitnessapp.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "calendar_Table")
public class calendarDB {

    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String date;
    private String excerciseName;
    private int weight;
    private int sets;

    public calendarDB(int ID,String date, String excerciseName, int weight,int sets){
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
