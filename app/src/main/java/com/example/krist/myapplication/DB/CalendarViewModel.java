package com.example.krist.myapplication.DB;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.krist.myapplication.Repository.calendarRepository;

import java.util.List;

public class CalendarViewModel extends AndroidViewModel {

    private calendarRepository repositoryCal;
    private LiveData<List<Calendar_D>> allCalendars;
    public CalendarViewModel(@NonNull Application application) {
        super(application);
        repositoryCal = new calendarRepository(application);
        allCalendars = repositoryCal.getAllCalendar();
    }

    public void insert(Calendar_D calendar){
        repositoryCal.insret(calendar);
    }

    public void update(Calendar_D calendar){
        repositoryCal.update(calendar);
    }

    public void delete(Calendar_D calendar){
        repositoryCal.delete(calendar);
    }

    public LiveData<List<Calendar_D>>getAllCalendars(){
        return  allCalendars;
    }
}
