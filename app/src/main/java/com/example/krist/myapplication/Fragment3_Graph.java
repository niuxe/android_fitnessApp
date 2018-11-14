package com.example.krist.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krist.myapplication.DB.Fitness;
import com.example.krist.myapplication.DB.FitnessViewModel;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;


public class Fragment3_Graph extends Fragment {
    private FitnessViewModel FVM;
    private LineGraphSeries<DataPoint> squatSeries;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.graph_fragment, container, false);

        FVM = ViewModelProviders.of(this).get(FitnessViewModel.class);

        GraphView squatGraph = rootView.findViewById(R.id.graph);
        squatGraph.getViewport().setScalable(true);
        squatGraph.getViewport().setScalableY(true);

        FVM.getAllFitness().observe(this, new Observer<List<Fitness>>() {
            @Override
            public void onChanged(@Nullable List<Fitness> fitnesses) {

                if(!fitnesses.isEmpty()) {
                    squatSeries = new LineGraphSeries<>(FVM.getSquats());

                }

            }
        });
        if(squatSeries != null)
        squatGraph.addSeries(squatSeries);


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();


    }


}
