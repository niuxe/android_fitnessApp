package com.example.patih.fitnessapp.DB;

@Entity(tableName = "Execercises_table")
public class excercisesDB {
    private String excerciseName;
    private String excerciseTag;

    public excercisesDB(String excerciseName, String excerciseTag){
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
