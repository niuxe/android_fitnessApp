package com.example.krist.myapplication;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.krist.myapplication.DB.FitnessViewModel;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class Fragment3_Graph extends Fragment {
    private FitnessViewModel FVM;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.graph_fragment, container, false);

        FVM = ViewModelProviders.of(this).get(FitnessViewModel.class);

        GraphView squatGraph = rootView.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> squatSeries = new LineGraphSeries<>(FVM.getSquats());
        squatGraph.addSeries(squatSeries);

        FVM.getBenchPress();
        FVM.getDeadlift();


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();


    }
}
