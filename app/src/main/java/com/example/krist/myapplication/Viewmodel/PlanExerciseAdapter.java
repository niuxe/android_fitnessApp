package com.example.krist.myapplication.Viewmodel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.krist.myapplication.R;

import java.util.ArrayList;

public class PlanExerciseAdapter extends RecyclerView.Adapter<PlanExerciseAdapter.ViewHolder>{

    public interface iPlanExClickListener {
        void onPlanExClick(int clickedItemIndex);
    }
    final private iPlanExClickListener listener;

    private ArrayList<PlanExercise> planExList;

    public PlanExerciseAdapter(ArrayList<PlanExercise> planExList, iPlanExClickListener listener){
        this.planExList = planExList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanExerciseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.planning_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanExerciseAdapter.ViewHolder holder, int i) {
        holder.exName.setText(""+planExList.get(i).getName());
        holder.exTag.setText(""+Statics.TagToString(planExList.get(i).getTag()));
        holder.weight.setText(""+Statics.WeightIncrement(planExList.get(i).getWeight()));
        holder.sets.setText(""+planExList.get(i).getSets());
    }

    @Override
    public int getItemCount() {
        return planExList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageButton weightDown, weightUp, setsDown, setsUp, suggestAccept, suggestDiscard;
        TextView exName, exTag, weight, sets;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            weightDown = itemView.findViewById(R.id.weightDown);
            weightUp = itemView.findViewById(R.id.weightUp);
            setsDown = itemView.findViewById(R.id.setsDown);
            setsUp = itemView.findViewById(R.id.setsUp);
            suggestAccept = itemView.findViewById(R.id.suggestAccept);
            suggestDiscard = itemView.findViewById(R.id.suggestDiscard);


            exName = itemView.findViewById(R.id.exName);
            exTag = itemView.findViewById(R.id.exTag);
            weight = itemView.findViewById(R.id.weight);
            sets = itemView.findViewById(R.id.sets);

            weightDown.setOnClickListener(this);
            weightUp.setOnClickListener(this);
            setsDown.setOnClickListener(this);
            setsUp.setOnClickListener(this);
            suggestAccept.setOnClickListener(this);
            suggestDiscard.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onPlanExClick(getAdapterPosition());
        }
    }
}
