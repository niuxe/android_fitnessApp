package com.example.krist.myapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Fragment2_Today extends Fragment{

    RecyclerView exercisesList;
    RecyclerView.Adapter exerciseAdapter;
    FitnessViewModel FVM;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.today_fragment, container, false);
        FVM = ViewModelProviders.of(this).get(FitnessViewModel.class);

        exercisesList = rootView.findViewById(R.id.rv);
        exercisesList.hasFixedSize();
        exercisesList.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ArrayList<Exercises> exercises = new ArrayList<>();



        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date temp = Calendar.getInstance().getTime();
        final String todaysDate = dateFormat.format(temp);

        FVM.getAllFitness().observe(this, new android.arch.lifecycle.Observer<List<Fitness>>() {
            @Override
            public void onChanged(@Nullable List<Fitness> fitnesses) {
                if(!fitnesses.isEmpty()){
                    ArrayList<Fitness> todaysExercises = FVM.getExercisesToday(todaysDate);

                    for (Fitness fitness :todaysExercises) {
                        Exercises exercise = new Exercises(fitness.getExerciseName(), "Sets: " + fitness.getSets(), "Reps: " + fitness.getReps(), "Weight: " + fitness.getWeight());
                        exercises.add(exercise);
                    }

                    exerciseAdapter = new ExercisesAdapter(exercises);
                    exercisesList.setAdapter(exerciseAdapter);
                }

            }
        });



        return rootView;
    }
}
