package com.example.krist.myapplication.Viewmodel;

public final class Statics {

    public static String TagToString(ExerciseTag tag){
        String ret = "Error";
        switch(tag){
            case BICEPS: ret = "Biceps";
                break;
            case TRICEPS: ret = "Triceps";
                break;
            case SHOULDER: ret= "Shoulders";
                break;
            case CHEST: ret = "Chest";
                break;
            case BACK: ret = "Back";
                break;
            case LEGS:ret = "Legs";
                break;
        }
        return ret;
    }

    public static ExerciseTag IntToTag(int input){
        switch(input){
            case 0:
                return ExerciseTag.BICEPS;
            case 1:
                return ExerciseTag.TRICEPS;
            case 2:
                return ExerciseTag.SHOULDER;
            case 3:
                return ExerciseTag.CHEST;
            case 4:
                return ExerciseTag.BACK;
            case 5:
                return ExerciseTag.LEGS;
            default:
                return null;
        }
    }
    public static double WeightIncrement(int increment){
        double weightMultiplier = 2.5;
        return (increment * weightMultiplier);
    }
}
