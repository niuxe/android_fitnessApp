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
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;


public class Fragment3_Graph extends Fragment {
    private FitnessViewModel FVM;
    private LineGraphSeries<DataPoint> squatSeries;
    private LineGraphSeries<DataPoint> deadliftSeries;
    private LineGraphSeries<DataPoint> benchpressSeries;
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.graph_fragment, container, false);

        FVM = ViewModelProviders.of(this).get(FitnessViewModel.class);

        final GraphView progressGraph = (GraphView) rootView.findViewById(R.id.graph);

        squatSeries = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 0)
        });

        deadliftSeries = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 0)
        });

        benchpressSeries = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 0)
        });

        //Squat line
        squatSeries.setThickness(8);
        squatSeries.setDataPointsRadius(15);
        squatSeries.setColor(Color.GREEN);
        squatSeries.setDrawDataPoints(true);

        //deadlift line
        deadliftSeries.setThickness(8);
        deadliftSeries.setDataPointsRadius(15);
        deadliftSeries.setColor(Color.RED);
        deadliftSeries.setDrawDataPoints(true);

        //bench press line
        benchpressSeries.setThickness(8);
        benchpressSeries.setDataPointsRadius(15);
        benchpressSeries.setColor(Color.BLUE);
        benchpressSeries.setDrawDataPoints(true);

        FVM.getAllFitness().observe(this, new Observer<List<Fitness>>() {
            @Override
            public void onChanged(@Nullable List<Fitness> fitnesses) {
                if (!fitnesses.isEmpty()) {
                    for (DataPoint temp : FVM.getSquats()) {
                        if (temp != null) {
                            Log.e("hej", temp.getX() + "");
                            squatSeries.appendData(temp, false, 15, true);

                            progressGraph.getViewport().setMinX(0);
                            progressGraph.getViewport().setMinY(0);
                            progressGraph.getViewport().setMaxX(20);
                            progressGraph.getViewport().setMaxY(200);

                            progressGraph.addSeries(squatSeries);
                            progressGraph.getViewport().scrollToEnd();
                        }
                    }

                    for (DataPoint temp : FVM.getDeadlift()) {
                        if (temp != null) {
                            Log.e("hej", temp.getX() + "");
                            deadliftSeries.appendData(temp, false, 15, true);

                            progressGraph.getViewport().setMinX(0);
                            progressGraph.getViewport().setMinY(0);
                            progressGraph.getViewport().setMaxX(20);
                            progressGraph.getViewport().setMaxY(200);

                            progressGraph.addSeries(deadliftSeries);
                            progressGraph.getViewport().scrollToEnd();
                        }
                    }

                    for (DataPoint temp : FVM.getBenchPress()) {
                        if (temp != null) {
                            Log.e("hej", temp.getX() + "");
                            benchpressSeries.appendData(temp, false, 15, true);

                            progressGraph.getViewport().setMinX(0);
                            progressGraph.getViewport().setMinY(0);
                            progressGraph.getViewport().setMaxX(20);
                            progressGraph.getViewport().setMaxY(200);

                            progressGraph.addSeries(benchpressSeries);
                            progressGraph.getViewport().scrollToEnd();
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