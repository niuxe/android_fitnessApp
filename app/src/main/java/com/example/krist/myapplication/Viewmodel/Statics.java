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
            case LEGS:ret = "legs";
                break;
        }
        return ret;
    }

    public static double WeightIncrement(int increment){
        double weightMultiplier = 2.5;
        return (increment * weightMultiplier);
    }
}
