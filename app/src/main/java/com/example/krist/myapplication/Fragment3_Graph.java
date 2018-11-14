package com.example.krist.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
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
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;


public class Fragment3_Graph extends Fragment {
    private FitnessViewModel FVM;
    private LineGraphSeries<DataPoint> squatSeries;
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.graph_fragment, container, false);

        FVM = ViewModelProviders.of(this).get(FitnessViewModel.class);

        final GraphView squatGraph = (GraphView) rootView.findViewById(R.id.graph);

        squatSeries = new LineGraphSeries<>(new DataPoint[]{
            new DataPoint(0, 50)
        });

        squatSeries.setThickness(8);
        squatSeries.setDataPointsRadius(15);
        squatSeries.setColor(Color.GREEN);
        squatSeries.setDrawDataPoints(true);



        FVM.getAllFitness().observe(this, new Observer<List<Fitness>>() {
            @Override
            public void onChanged(@Nullable List<Fitness> fitnesses) {
                if(!fitnesses.isEmpty()) {
                    for (DataPoint temp: FVM.getSquats()) {
                        if(temp != null) {
                            Log.e("hej", temp.getX() + "");
                            squatSeries.appendData(temp, false, 15, true);

                            squatGraph.getViewport().setMinX(0);
                            squatGraph.getViewport().setMinY(0);
                            squatGraph.getViewport().setMaxX(20);
                            squatGraph.getViewport().setMaxY(200);

                            squatGraph.addSeries(squatSeries);
                        }
                    }
                }
            }
        });



        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();


    }


}
