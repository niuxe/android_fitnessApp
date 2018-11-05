package com.example.krist.myapplication.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "excercises_Table")
public class excercises {

    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String excerciseName;
    private String excerciseTag;

    public excercises(int ID, String excerciseName, String excerciseTag){
        //this.ID=ID;
        this.excerciseName = excerciseName;
        this.excerciseTag = excerciseTag;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getExcerciseName(){
        return excerciseName;
    }
    public String getExcerciseTag(){
        return excerciseTag;
    }
    public int getID() {
        return ID;
    }
}

