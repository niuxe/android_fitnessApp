package com.example.krist.myapplication.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.krist.myapplication.DB.DAO;
import com.example.krist.myapplication.DB.Excercise;
import com.example.krist.myapplication.DB.excercisesDatabase;

import java.util.List;

public class excercisesRepository {
    private DAO excercisesDAO;
    private LiveData<List<Excercise>> allExcercises;

    public excercisesRepository(Application application){
        excercisesDatabase databaseEx = excercisesDatabase.getInstance(application);
    excercisesDAO = databaseEx.excerciseDAO();
    allExcercises = excercisesDAO.getAllExcercises();
    }

    public void insert(Excercise excercises){
    new insertExcercisesAsyncTask(excercisesDAO).execute(excercises);
    }

    public void update(Excercise excercises){
        new updateExcercisesAsyncTask(excercisesDAO).execute(excercises);
    }

    public void delete(Excercise excercises){
        new deleteAllExcercisesAsyncTask(excercisesDAO).execute(excercises);
    }

    public void deleteAllExcercises(){
        new deleteAllExcercisesAsyncTask(excercisesDAO).execute();
    }

    public LiveData<List<Excercise>>getAllExcercises(){
        return  allExcercises;
    }

    private static class insertExcercisesAsyncTask extends AsyncTask<Excercise, Void, Void>{
        private DAO excercisesDAO;

        private insertExcercisesAsyncTask(DAO excercisesDAO){
            this.excercisesDAO = excercisesDAO;}
        @Override
        protected Void doInBackground(Excercise... excercises) {
            excercisesDAO.insert(excercises[0]);
            return null;
        }
    }

    private static class updateExcercisesAsyncTask extends AsyncTask<Excercise, Void, Void>{
        private DAO excercisesDAO;

        private updateExcercisesAsyncTask(DAO excercisesDAO)
        {
            this.excercisesDAO = excercisesDAO;
        }
        @Override
        protected Void doInBackground(Excercise... excercises) {
            excercisesDAO.update(excercises[0]);
            return null;
        }
    }

    private static class deleteExcercisesAsyncTask extends AsyncTask<Excercise, Void, Void>{
        private DAO excercisesDAO;

        private deleteExcercisesAsyncTask(DAO excercisesDAO)
        {
            this.excercisesDAO = excercisesDAO;
        }
        @Override
        protected Void doInBackground(Excercise... excercises) {
            excercisesDAO.delete(excercises[0]);
            return null;
        }
    }

    private static class deleteAllExcercisesAsyncTask extends AsyncTask<Excercise, Void, Void>{
        private DAO excercisesDAO;

        private deleteAllExcercisesAsyncTask(DAO excercisesDAO){
            this.excercisesDAO = excercisesDAO;
        }

        @Override
        protected Void doInBackground(Excercise... excercises) {
            excercisesDAO.deleteAllCalendar();
            return null;
        }
    }
}

