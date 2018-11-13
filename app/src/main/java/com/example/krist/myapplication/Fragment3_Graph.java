package com.example.krist.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.krist.myapplication.DB.FitnessViewModel;


public class Fragment3_Graph extends Fragment {
    FitnessViewModel FVM;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.graph_fragment, container, false);

        //FVM.getSquats();
        //FVM.getBenchPress();
        //&FVM.getDeadlift();


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();


    }
}
