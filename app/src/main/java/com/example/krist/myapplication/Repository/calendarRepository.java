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
        calendarDatabase databaseCal = calendarDatabase.getInstance(application);
        excercisesDAO = databaseCal.excerciseDAO();
        allCalendar = excercisesDAO.getAllCalendars();
    }

    public void insret (calendar calendar){
        new insertCalendarAsyncTask(excercisesDAO).execute(calendar);
    }

    public void update(calendar calendar){
        new updateCalendarAsyncTask(excercisesDAO).execute(calendar);
    }

    public void delete(calendar calendar){
        new deleteCalendarAsyncTask(excercisesDAO).execute(calendar);
    }

    public void deleteAllCalendar(){
    }

    public LiveData<List<calendar>> getAllCalendar() {
        return allCalendar;
    }

    private static class insertCalendarAsyncTask extends AsyncTask<calendar, Void, Void>{
    private DAO excercisesDAO;

    private insertCalendarAsyncTask(DAO excercisesDAO){
        this.excercisesDAO = excercisesDAO;
    }

        @Override
        protected Void doInBackground(calendar... calendars) {
            excercisesDAO.insert(calendars[0]);
            return null;
        }
    }

    private static class updateCalendarAsyncTask extends AsyncTask<calendar, Void, Void>{
        private DAO excercisesDAO;

        private updateCalendarAsyncTask(DAO excercisesDAO){
            this.excercisesDAO = excercisesDAO;
        }

        @Override
        protected Void doInBackground(calendar... calendars) {
            excercisesDAO.update(calendars[0]);
            return null;
        }
    }

    private static class deleteCalendarAsyncTask extends AsyncTask<calendar , Void, Void>{
        private DAO excercisesDAO;

        private deleteCalendarAsyncTask(DAO excercisesDAO){
            this.excercisesDAO = excercisesDAO;
        }

        @Override
        protected Void doInBackground(calendar... calendars) {
            excercisesDAO.delete(calendars[0]);
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
            excercisesDAO.deleteAllCalendar();
            return null;
        }
    }
}
