package com.example.krist.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.krist.myapplication.DB.ExcerciseViewModel;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class Fragment3_Graph extends Fragment {
    ExcerciseViewModel EVM;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.graph_fragment, container, false);
        //Check if the list have been populated
        EVM.GraphSortExercises();

        //Find the graph
        GraphView graph = rootView.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> lineGraphSeries = new LineGraphSeries<>(new DataPoint[] {

        });


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();

        EVM.ClearGraphs();
    }
}
