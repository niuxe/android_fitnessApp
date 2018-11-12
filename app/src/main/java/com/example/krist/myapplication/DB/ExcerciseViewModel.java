package com.example.krist.myapplication.DB;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.krist.myapplication.Exercises;
import com.example.krist.myapplication.Repository.excercisesRepository;

import java.util.ArrayList;
import java.util.List;

public class ExcerciseViewModel extends AndroidViewModel {

    private excercisesRepository repositoryEx;
    private LiveData<List<Excercise_D>> allExcercises;

    public ExcerciseViewModel(@NonNull Application application) {
        super(application);
        repositoryEx = new excercisesRepository(application);
        allExcercises = repositoryEx.getAllExcercises();
    }

    public void insert(Excercise_D excercise){
        repositoryEx.insert(excercise);
    }
    public void update(Excercise_D excercise){
        repositoryEx.update(excercise);
    }
    public void delete(Excercise_D excercise){
        repositoryEx.delete(excercise);
    }

    public LiveData<List<Excercise_D>> getAllExcercises() {
        return allExcercises;
    }

    ArrayList<Exercises> exercises = new ArrayList<>();
    ArrayList<Exercises> Squats = new ArrayList<>();
    ArrayList<Exercises> Deadlift = new ArrayList<>();
    ArrayList<Exercises> BenchPress = new ArrayList<>();

    public void GraphSortExercises() {
        if (Squats.isEmpty() && Deadlift.isEmpty() && BenchPress.isEmpty()) {

            for (Exercises E : exercises) {
                if (E.getExerciseName().equalsIgnoreCase("Squat")) {
                    //Add to the squat graph
                } else if (E.getExerciseName().equalsIgnoreCase("Deadlift")) {
                    //Add to the deadlift graph
                } else if (E.getExerciseName().equalsIgnoreCase("Bench press")) {
                    //Add to Bench press graph
                }
            }
        }
    }

    public void ClearGraphs() {
        Squats.clear();
        Deadlift.clear();
        BenchPress.clear();
    }

}
