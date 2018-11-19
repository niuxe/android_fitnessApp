package com.example.krist.myapplication.DB;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FitnessViewModel extends AndroidViewModel {

    private FitnessRepository repository;
    private LiveData<List<Fitness>>allFitness;

    public FitnessViewModel(@NonNull Application application){
        super(application);
        repository = new FitnessRepository(application);
        allFitness = repository.getAllFitness();
    }

    public void insert(Fitness fitnes){
        repository.insert(fitnes);
    }
    public void update(Fitness fitnes){
        repository.update(fitnes);
    }

    public void delete(Fitness fitnes){
        repository.delete(fitnes);
    }

    public LiveData<List<Fitness>>getAllFitness(){
        return allFitness;
    }

    DataPoint[] squats = null;
    public DataPoint[] getSquats(){
        if(squats != null) return squats;

        int size = getAllFitness().getValue().size();
        squats = new DataPoint[getAllFitness().getValue().size()];
        int indexer = 0;
        int xAxis  = 1;

        for (Fitness fitness :allFitness.getValue()) {
            if (fitness.getExerciseName().equalsIgnoreCase("squat")) {
                //Substring day and months from the date
                int month = Integer.valueOf(fitness.getDate().substring(3, 5));
                int day = Integer.valueOf(fitness.getDate().substring(0, 2));
                int year = Integer.valueOf(fitness.getDate().substring(8));
                int date = (month*100) + day;
                //create a new datapoint
                DataPoint tempDP = new DataPoint(xAxis, fitness.getWeight());
                //Insert datapoint into array and increment counter
                squats[indexer] = tempDP;
                indexer++;
                xAxis++;
            }
        }
        return squats;
    }

    DataPoint[] deadlift = null;
    public DataPoint[] getDeadlift(){
        if(deadlift != deadlift) return deadlift;

        deadlift = new DataPoint[getAllFitness().getValue().size()];
        int indexer = 0;
        int xAxis  = 1;

        for (Fitness fitness :allFitness.getValue()) {
            if(fitness.getExerciseName().equalsIgnoreCase("deadlift")) {
                //Substring day and months from the date
                int month = Integer.valueOf(fitness.getDate().substring(3,5));
                int day = Integer.valueOf(fitness.getDate().substring(0,2));
                int year = Integer.valueOf(fitness.getDate().substring(6));
                int date = (year*10000) + (month*100) + day;
                //create a new datapoint
                DataPoint tempDP = new DataPoint(xAxis, fitness.getWeight());
                //Insert datapoint into array and increment counter
                deadlift[indexer] = tempDP;
                indexer++;
                xAxis++;
            }
        }

        return deadlift;
    }

    DataPoint[] benchpress = null;
    public DataPoint[] getBenchPress(){
        if(benchpress != null) return benchpress;

        benchpress = new DataPoint[getAllFitness().getValue().size()];
        int indexer = 0;
        int xAxis  = 1;

        for (Fitness fitness :allFitness.getValue()) {
            if(fitness.getExerciseName().equalsIgnoreCase("bench press")) {
                //Substring day and months from the date
                int month = Integer.valueOf(fitness.getDate().substring(3,5));
                int day = Integer.valueOf(fitness.getDate().substring(0,2));
                int year = Integer.valueOf(fitness.getDate().substring(6));
                int date = (year*10000) + (month*100) + day;
                //create a new datapoint
                DataPoint tempDP = new DataPoint(xAxis, fitness.getWeight());
                //Insert datapoint into array and increment counter
                benchpress[indexer] = tempDP;
                indexer++;
                xAxis++;
            }
        }

        return benchpress;
    }

    public ArrayList<Fitness> getExercisesToday(String date) {
        ArrayList<Fitness> temp = new ArrayList<>();
        for (Fitness fitness: allFitness.getValue()){
            String test = fitness.getDate();
            if(test.equalsIgnoreCase(date)){
                temp.add(fitness);
            }
        }
        return temp;
    }
}
