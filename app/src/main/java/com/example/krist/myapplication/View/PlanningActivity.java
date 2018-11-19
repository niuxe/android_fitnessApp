package com.example.krist.myapplication.View;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.krist.myapplication.R;
import com.example.krist.myapplication.Viewmodel.ExerciseTag;
import com.example.krist.myapplication.Viewmodel.PlanExercise;
import com.example.krist.myapplication.Viewmodel.PlanExerciseAdapter;
import com.example.krist.myapplication.Viewmodel.Statics;

import java.util.ArrayList;


public class PlanningActivity  extends AppCompatActivity implements PlanExerciseAdapter.iPlanExClickListener{

    private RecyclerView planExList;
    private PlanExerciseAdapter planExAdapter;

    AlertDialog dialog;
    private int weightValue = 1;
    private int setsValue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planning_activity);

        planExList = findViewById(R.id.planExList);
        planExList.setLayoutManager(new LinearLayoutManager(this));

        planExAdapter = new PlanExerciseAdapter(GenPlanExercises(), this);
        planExList.setAdapter(planExAdapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.new_plan_item_dialog);
        dialog = builder.create();
    }

    public ArrayList<PlanExercise> GenPlanExercises(){
        ArrayList<PlanExercise> genList = new ArrayList<PlanExercise>();
        genList.add(new PlanExercise("Benchpress that s**t", ExerciseTag.CHEST, 1,1,true));
        return genList;
    }

    public void CallNamingDialog(){
        dialog.show();
        ImageButton setsUp = dialog.findViewById(R.id.setsUp);
        ImageButton setsDown = dialog.findViewById(R.id.setsDown);
        TextView sets = dialog.findViewById(R.id.sets);
        ImageButton weightUp = dialog.findViewById(R.id.weightUp);
        ImageButton weightDown = dialog.findViewById(R.id.weightDown);
        TextView weight =dialog.findViewById(R.id.weight);
        Button okButton = dialog.findViewById(R.id.okButton);
        Button cancelButton = dialog.findViewById(R.id.cancelButton);

        sets.setText(""+setsValue);
        weight.setText(""+weightValue);

        weightUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                diaWeightUp();
            }
        });

        weightDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                diaWeightDown();
            }
        });

        setsUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                diaSetsUp();
            }
        });

        setsDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                diaSetsDown();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addNewPlanExercise();
                dialog.hide();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.hide();
            }
        });
    }
    private void diaWeightUp(){
        TextView weight =dialog.findViewById(R.id.weight);
        weightValue+=1;
        weight.setText(""+Statics.WeightIncrement(weightValue));
    }
    private void diaWeightDown(){
        TextView weight =dialog.findViewById(R.id.weight);
        weightValue-=1;
        weight.setText(""+Statics.WeightIncrement(weightValue));
    }
    private void diaSetsUp(){
        TextView sets = dialog.findViewById(R.id.sets);
        setsValue+=1;
        sets.setText(setsValue);
    }

    private void diaSetsDown(){
        TextView sets = dialog.findViewById(R.id.sets);
        setsValue-=1;
        sets.setText(setsValue);
    }

    private void addNewPlanExercise(){
        EditText nameInput = dialog.findViewById(R.id.nameInput);
        Spinner tagSpinner = dialog.findViewById(R.id.tagSpinner);


        planExAdapter.getPlanExList().add(new PlanExercise(nameInput.getText().toString(), Statics.IntToTag(tagSpinner.getSelectedItemPosition()), weightValue, setsValue, false ));
        planExAdapter.notifyItemChanged(planExAdapter.getPlanExList().size()-1);
    }

    @Override
    public void onPlanExClick(int clickedItemIndex) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
