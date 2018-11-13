package com.example.krist.myapplication;

public class Exercises {

    private String exerciseName;
    private String sets;
    private String reps;

    public Exercises(String exerciseName,String sets, String reps){
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }
}
