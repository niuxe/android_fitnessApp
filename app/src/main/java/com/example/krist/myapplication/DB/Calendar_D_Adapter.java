package com.example.krist.myapplication.DB;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.krist.myapplication.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Calendar_D_Adapter extends RecyclerView.Adapter<Calendar_D_Adapter.Calendar_DHolder> {

    private List<Calendar_D> calendarD = new ArrayList<>();

    @NonNull
    @Override
    public Calendar_DHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.calendar_fragment,parent,false);
        return new Calendar_DHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Calendar_DHolder calendar_dHolder, int i) {
        Calendar currentDay = calendarD.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Calendar_DHolder extends RecyclerView.ViewHolder{
        private TextView todaysDate ;
        private TextView todaysWorkout;
        private CalendarView calendarView;

        public Calendar_DHolder(@NonNull View itemView) {
            super(itemView);
            todaysDate = itemView.findViewById(R.id.todaysDateView);
            todaysWorkout = itemView.findViewById(R.id.todaysWorkoutView);
            calendarView = itemView.findViewById(R.id.calendarView);

        }
    }
}
