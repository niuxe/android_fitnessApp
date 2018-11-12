package com.example.krist.myapplication.DB;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

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
}
