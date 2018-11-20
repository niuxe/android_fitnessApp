package com.example.krist.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ViewHolder> {

    private ArrayList<Exercises> exercises;

    public ExercisesAdapter(ArrayList<Exercises> exercises){
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ExercisesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.today_exercises_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExercisesAdapter.ViewHolder viewHolder, int i) {
        viewHolder.exerciseName.setText(exercises.get(i).getExerciseName());
        viewHolder.setsView.setText(exercises.get(i).getSets() + "");
        viewHolder.repsView.setText(exercises.get(i).getReps() + "");
        viewHolder.weightView.setText(exercises.get(i).getWeight() + "");
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView exerciseName;
        TextView setsView;
        TextView repsView;
        TextView weightView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            exerciseName = itemView.findViewById(R.id.exerciseName);
            setsView = itemView.findViewById(R.id.sets);
            repsView = itemView.findViewById(R.id.reps);
            weightView = itemView.findViewById(R.id.weight);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
