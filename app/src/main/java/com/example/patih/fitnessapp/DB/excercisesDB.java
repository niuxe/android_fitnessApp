package com.example.patih.fitnessapp.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "excercises_Table")
public class excercisesDB {

    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String excerciseName;
    private String excerciseTag;

    public excercisesDB(int ID,String excerciseName, String excerciseTag){
        this.ID=ID;
        this.excerciseName = excerciseName;
        this.excerciseTag = excerciseTag;
    }

    public void setExcerciseName(String excerciseName){
        this.excerciseName = excerciseName;
    }

    public void setExcerciseTag(String excerciseTag){
        this.excerciseTag =excerciseTag;
    }

    public String getExcerciseName(){
        return excerciseName;
    }

    public String getExcerciseTag(){
        return excerciseTag;
    }
}
