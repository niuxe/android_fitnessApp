package com.example.krist.myapplication.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.krist.myapplication.DB.DAO;
import com.example.krist.myapplication.DB.Calendar;
import com.example.krist.myapplication.DB.calendarDatabase;

import java.util.List;

public class calendarRepository {

    private DAO calendarDAO;
    private LiveData<List<Calendar>> allCalendar;

    public calendarRepository(Application application){
        calendarDatabase databaseCal = calendarDatabase.getInstance(application);
        calendarDAO = databaseCal.excerciseDAO();
        allCalendar = calendarDAO.getAllCalendars();
    }

    public void insret (Calendar Calendar){
        new insertCalendarAsyncTask(calendarDAO).execute(Calendar);
    }

    public void update(Calendar Calendar){
        new updateCalendarAsyncTask(calendarDAO).execute(Calendar);
    }

    public void delete(Calendar Calendar){
        new deleteCalendarAsyncTask(calendarDAO).execute(Calendar);
    }

    public void deleteAllCalendar(){
    }

    public LiveData<List<Calendar>> getAllCalendar() {
        return allCalendar;
    }

    private static class insertCalendarAsyncTask extends AsyncTask<Calendar, Void, Void>{
    private DAO calendarDAO;

    private insertCalendarAsyncTask(DAO excercisesDAO){
        this.calendarDAO = excercisesDAO;
    }

        @Override
        protected Void doInBackground(Calendar... Calendars) {
            calendarDAO.insert(Calendars[0]);
            return null;
        }
    }

    private static class updateCalendarAsyncTask extends AsyncTask<Calendar, Void, Void>{
        private DAO calendarDAO;

        private updateCalendarAsyncTask(DAO excercisesDAO){
            this.calendarDAO = excercisesDAO;
        }

        @Override
        protected Void doInBackground(Calendar... Calendars) {
            calendarDAO.update(Calendars[0]);
            return null;
        }
    }

    private static class deleteCalendarAsyncTask extends AsyncTask<Calendar, Void, Void>{
        private DAO calendarDAO;

        private deleteCalendarAsyncTask(DAO excercisesDAO){
            this.calendarDAO = excercisesDAO;
        }

        @Override
        protected Void doInBackground(Calendar... Calendars) {
            calendarDAO.delete(Calendars[0]);
            return null;
        }
    }

    private static class deleteAllCalendarAsyncTask extends AsyncTask<Void, Void, Void>{
        private DAO calendarDAO;

        private deleteAllCalendarAsyncTask(DAO excercisesDAO){
            this.calendarDAO = excercisesDAO;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            calendarDAO.deleteAllCalendar();
            return null;
        }
    }
}
