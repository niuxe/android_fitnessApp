package com.example.krist.myapplication;

public class Exercises {

    private String exerciseName;
    private int sets;
    private int reps;
    private int weight;

    public Exercises(String exerciseName,int sets, int reps, int weight){
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() { return weight; }

    public void setWeight(int weight) {this.weight = weight; }
}
