package com.example.krist.myapplication.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.krist.myapplication.DB.CalendarDatabase;
import com.example.krist.myapplication.DB.Calendar_D;
import com.example.krist.myapplication.DB.DAO;

import java.util.List;

public class calendarRepository {

    private DAO calendarDAO;
    private LiveData<List<Calendar_D>> allCalendar;

    public calendarRepository(Application application){
        CalendarDatabase databaseCal = CalendarDatabase.getInstance(application);
        calendarDAO = databaseCal.excerciseDAO();
        //allCalendar = calendarDAO.getAllCalendars();
    }

    public void insret (Calendar_D Calendar){
        new insertCalendarAsyncTask(calendarDAO).execute(Calendar);
    }

    public void update(Calendar_D Calendar){
        new updateCalendarAsyncTask(calendarDAO).execute(Calendar);
    }

    public void delete(Calendar_D Calendar){
        new deleteCalendarAsyncTask(calendarDAO).execute(Calendar);
    }

    public void deleteAllCalendar(){
    }

    public LiveData<List<Calendar_D>> getAllCalendar() {
        return allCalendar;
    }

    private static class insertCalendarAsyncTask extends AsyncTask<Calendar_D, Void, Void>{
    private DAO calendarDAO;

    private insertCalendarAsyncTask(DAO calendarDAO){

        this.calendarDAO = calendarDAO;
    }

        @Override
        protected Void doInBackground(Calendar_D... Calendars) {
            calendarDAO.insert(Calendars[0]);
            return null;
        }
    }

    private static class updateCalendarAsyncTask extends AsyncTask<Calendar_D, Void, Void>{
        private DAO calendarDAO;

        private updateCalendarAsyncTask(DAO calendarDAO){
            this.calendarDAO = calendarDAO;
        }

        @Override
        protected Void doInBackground(Calendar_D... Calendars) {
            calendarDAO.update(Calendars[0]);
            return null;
        }
    }

    private static class deleteCalendarAsyncTask extends AsyncTask<Calendar_D, Void, Void>{
        private DAO calendarDAO;

        private deleteCalendarAsyncTask(DAO calendarDAO){
            this.calendarDAO = calendarDAO;
        }

        @Override
        protected Void doInBackground(Calendar_D... Calendars) {
            calendarDAO.delete(Calendars[0]);
            return null;
        }
    }

    private static class deleteAllCalendarAsyncTask extends AsyncTask<Void, Void, Void>{
        private DAO calendarDAO;

        private deleteAllCalendarAsyncTask(DAO calendarDAO){
            this.calendarDAO = calendarDAO;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            //calendarDAO.deleteAllCalendar();
            return null;
        }
    }
}
