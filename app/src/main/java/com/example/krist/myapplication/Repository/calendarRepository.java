package com.example.krist.myapplication.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

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
        new insertCalendarAsyncTask(excercisesDAO).execute(calendar);
    }

    public void update(Calendar calendar){
    }

    public void delete(Calendar calendar){
    }

    public void deleteAllCalendar(){
    }

    public LiveData<List<calendar>> getAllCalendar() {
        return allCalendar;
    }

    private static class insertCalendarAsyncTask extends AsyncTask<Calendar, Void, Void>{
    private DAO excercisesDAO;

    private insertCalendarAsyncTask(DAO excercisesDAO){
        this.excercisesDAO = excercisesDAO;
    }
        @Override
        protected Void doInBackground(Calendar... calendars) {
        excercisesDAO.insert(calendar[0]);
            return null;
        }
    }

    private static class updateCalendarAsyncTask extends AsyncTask<Calendar, Void, Void>{
        private DAO excercisesDAO;

        private updateCalendarAsyncTask(DAO excercisesDAO){
            this.excercisesDAO = excercisesDAO;
        }
        @Override
        protected Void doInBackground(Calendar... calendars) {
            excercisesDAO.update(calendar[0]);
            return null;
        }
    }

    private static class deleteCalendarAsyncTask extends AsyncTask<Calendar, Void, Void>{
        private DAO excercisesDAO;

        private deleteCalendarAsyncTask(DAO excercisesDAO){
            this.excercisesDAO = excercisesDAO;
        }
        @Override
        protected Void doInBackground(Calendar... calendars) {
            excercisesDAO.delete(calendar[0]);
            return null;
        }
    }

    private static class deleteAllCalendarAsyncTask extends AsyncTask<Void, Void, Void>{
        private DAO excercisesDAO;

        private deleteAllCalendarAsyncTask(DAO excercisesDAO){
            this.excercisesDAO = excercisesDAO;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            excercisesDAO.insert(calendar[0]);
            return null;
        }
    }
}
