package com.example.krist.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.krist.myapplication.View.PlanningActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Fragment1_Calendar extends Fragment{

    private TextView todaysDate ;
    private String sendDate;
    private TextView todaysWorkout;
    private CalendarView calendarView;
    private SimpleDateFormat dateFormat;
    private Date date;
    private String currentDate;
    private Intent addWorkoutIntent;
    private FloatingActionButton fab;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calendar_fragment, container, false);
        //displaying the current date above the calendar
        todaysDate = rootView.findViewById(R.id.todaysDateView);
        todaysWorkout = rootView.findViewById(R.id.todaysWorkout);
        fab = rootView.findViewById(R.id.fab);
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = new Date();
        currentDate = dateFormat.format(date);
        todaysDate.setText(currentDate);
        //displays the date you click on above the calendar
        calendarView = rootView.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day){
                sendDate = day + "/" + (month+1) + "/" + year;
                todaysDate.setText(sendDate);
            }
        });
        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                addWorkoutIntent = new Intent(Fragment1_Calendar.this.getActivity(),PlanningActivity.class);
                addWorkoutIntent.putExtra("key",sendDate);
                startActivity(addWorkoutIntent);
            }
        });


        return rootView;
    }

}
