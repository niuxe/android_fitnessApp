package com.example.krist.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.krist.myapplication.DB.ExcerciseViewModel;


public class Fragment3_Graph extends Fragment {
    ExcerciseViewModel EVM;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.graph_fragment, container, false);

        EVM.GraphSortExercises();

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();

        EVM.ClearGraphs();
    }
}
