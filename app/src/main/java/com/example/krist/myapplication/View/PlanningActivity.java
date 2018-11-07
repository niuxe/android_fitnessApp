package com.example.krist.myapplication.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.krist.myapplication.R;
import com.example.krist.myapplication.Viewmodel.ExerciseTag;
import com.example.krist.myapplication.Viewmodel.PlanExercise;
import com.example.krist.myapplication.Viewmodel.PlanExerciseAdapter;

import java.util.ArrayList;


public class PlanningActivity  extends AppCompatActivity implements PlanExerciseAdapter.iPlanExClickListener{

    private RecyclerView planExList;
    private RecyclerView.Adapter planExAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planning_activity);

        planExList = findViewById(R.id.planExList);
        planExList.setLayoutManager(new LinearLayoutManager(this));

        planExAdapter = new PlanExerciseAdapter(GenPlanExercises(), this);
        planExList.setAdapter(planExAdapter);
    }

    public ArrayList<PlanExercise> GenPlanExercises(){
        ArrayList<PlanExercise> genList = new ArrayList<PlanExercise>();
        genList.add(new PlanExercise("Benchpress that s**t", ExerciseTag.CHEST, 1,1,true));
        return genList;
    }

    @Override
    public void onPlanExClick(int clickedItemIndex) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
