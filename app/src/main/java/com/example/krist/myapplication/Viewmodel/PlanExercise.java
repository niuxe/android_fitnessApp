package com.example.krist.myapplication.Viewmodel;

public class PlanExercise {
    private String name;
    private ExerciseTag tag;
    private int weight, sets;
    private boolean isSuggestion;

    public PlanExercise(String name, ExerciseTag tag, int weight, int sets, boolean isSuggestion) {
        this.name = name;
        this.tag = tag;
        this.weight = weight;
        this.sets = sets;
        this.isSuggestion = isSuggestion;
    }

    public String getName() {
        return name;
    }

    public ExerciseTag getTag() {
        return tag;
    }

    public int getWeight() {
        return weight;
    }

    public int getSets() {
        return sets;
    }

    public boolean isSuggestion() {
        return isSuggestion;
    }
}
