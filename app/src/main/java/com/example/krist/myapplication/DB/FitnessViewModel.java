package com.example.krist.myapplication.DB;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
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


    public DataPoint[] getSquats(){
        getAllFitness();
        DataPoint[] temp = new DataPoint[getAllFitness().getValue().size()];
        int indexer = 0;

        for (Fitness fitness :allFitness.getValue()) {
            if(fitness.getExerciseName().equalsIgnoreCase("squat")) {
                //Substring day and months from the date
                int month = Integer.valueOf(fitness.getDate().substring(3,5));
                int day = Integer.valueOf(fitness.getDate().substring(0,2));
                //create a new datapoint
                DataPoint tempDP = new DataPoint(day, month);
                //Insert datapoint into array and increment counter
                temp[indexer] = tempDP;
                indexer++;
            }
        }

        return temp;
    }

    public DataPoint[] getDeadlift(){
        getAllFitness();
        DataPoint[] temp = new DataPoint[getAllFitness().getValue().size()];
        int indexer = 0;

        for (Fitness fitness :allFitness.getValue()) {
            if(fitness.getExerciseName().equalsIgnoreCase("deadlift")) {
                //Substring day and months from the date
                int month = Integer.valueOf(fitness.getDate().substring(3,5));
                int day = Integer.valueOf(fitness.getDate().substring(0,2));
                //create a new datapoint
                DataPoint tempDP = new DataPoint(day, month);
                //Insert datapoint into array and increment counter
                temp[indexer] = tempDP;
                indexer++;
            }
        }

        return temp;
    }

    public DataPoint[] getBenchPress(){
        getAllFitness();
        DataPoint[] temp = new DataPoint[getAllFitness().getValue().size()];
        int indexer = 0;

        for (Fitness fitness :allFitness.getValue()) {
            if(fitness.getExerciseName().equalsIgnoreCase("bench press")) {
                //Substring day and months from the date
                int month = Integer.valueOf(fitness.getDate().substring(3,5));
                int day = Integer.valueOf(fitness.getDate().substring(0,2));
                //create a new datapoint
                DataPoint tempDP = new DataPoint(day, month);
                //Insert datapoint into array and increment counter
                temp[indexer] = tempDP;
                indexer++;
            }
        }

        return temp;
    }
}
