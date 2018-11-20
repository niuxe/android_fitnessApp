package com.example.krist.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.myapplication.DB.Fitness;
import com.example.krist.myapplication.DB.FitnessViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;


public class Fragment2_Today extends Fragment{

    RecyclerView exercisesList;
    RecyclerView.Adapter exerciseAdapter;
    FitnessViewModel fitnessViewModel;
    String currentDate;
    SimpleDateFormat dateFormat;
    Date date;
    ArrayList<Exercises> exercises;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.today_fragment, container, false);

        fitnessViewModel = ViewModelProviders.of(this).get(FitnessViewModel.class);

        exercisesList = rootView.findViewById(R.id.rv);
        exercisesList.hasFixedSize();
        exercisesList.setLayoutManager(new LinearLayoutManager(getActivity()));

        exercises = new ArrayList<>();



        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = Calendar.getInstance().getTime() ;
        currentDate = dateFormat.format(date);

        fitnessViewModel.getAllFitness().observe(this, new Observer<List<Fitness>>() {
            @Override
            public void onChanged(@Nullable List<Fitness> fitnesses) {
                if(!fitnesses.isEmpty()){
                ArrayList<Fitness> todaysExercises = fitnessViewModel.getExercises(currentDate);

                for (Fitness f: todaysExercises) {
                    exercises.add(new Exercises(f.getExerciseName(), f.getSets(), f.getReps(), f.getWeight()));
                }
                    exerciseAdapter = new ExercisesAdapter(exercises);
                    exercisesList.setAdapter(exerciseAdapter);
            }
            }
        });






        return rootView;
    }
}
