package com.example.krist.myapplication.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.krist.myapplication.DB.DAO;
import com.example.krist.myapplication.DB.calendar;
import com.example.krist.myapplication.DB.calendarDatabase;

import java.util.Calendar;
import java.util.List;

public class calendarRepository {

    private DAO excercisesDAO;
    private LiveData<List<calendar>> allCalendar;

    public calendarRepository(Application application){
        calendarDatabase databasecal = calendarDatabase.getInstance(application);
        excercisesDAO = databasecal.excerciseDAO();
        allCalendar = excercisesDAO.getAllCalendars();
    }

    public void insret (Calendar calendar){

    }

    public void update(Calendar calendar){

    }
}
