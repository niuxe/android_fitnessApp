package com.example.krist.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Fragment2_Today extends Fragment{

    RecyclerView exercisesList;
    RecyclerView.Adapter exerciseAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.today_fragment, container, false);

        exercisesList = rootView.findViewById(R.id.rv);
        exercisesList.hasFixedSize();
        exercisesList.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Exercises> exercises = new ArrayList<>();

        exerciseAdapter = new ExercisesAdapter(exercises);
        exercisesList.setAdapter(exerciseAdapter);



        return rootView;
    }
}
