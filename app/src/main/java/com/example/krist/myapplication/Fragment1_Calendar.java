package com.example.krist.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Fragment1_Calendar extends Fragment{

    private TextView todaysDate ;
    private TextView todaysWorkout;
    private CalendarView calendarView;
    private java.util.Calendar c;
    private SimpleDateFormat dateFormat;
    private Date date;
    private String currentDate;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calendar_fragment, container, false);
        //displaying the current date above the calendar
        todaysDate = rootView.findViewById(R.id.todaysDateView);
        c = java.util.Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = new Date();
        currentDate = dateFormat.format(date);
        todaysDate.setText(currentDate);
        //displays the date you click on above the calendar
        calendarView = rootView.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day){
                String date = day + "/" + (month+1) + "/" + year;
                todaysDate.setText(date);
            }
        });
        //here it should be displaying the workout below the calendar.. will implement after database is ready.
        todaysWorkout = rootView.findViewById(R.id.todaysWorkoutView);

        return rootView;
    }

}
