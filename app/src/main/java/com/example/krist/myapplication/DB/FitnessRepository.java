package com.example.krist.myapplication.DB;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class FitnessRepository {
    private FitnessDAO fitnessDao;
    private LiveData<List<Fitness>>allFitnes;

    public FitnessRepository(Application application){
        FitnessDB fitnessDB = FitnessDB.getInstance(application);
        fitnessDao = fitnessDB.fitnessDao();
        allFitnes = fitnessDao.getAllFitness();
    }

    public void insert(Fitness fitness){
        new InsertFitnessAsyncTask(fitnessDao).execute(fitness);
    }

    public void update(Fitness fitness){
        new UpdateFitnessAsyncTask(fitnessDao).execute(fitness);
    }

    public void delete(Fitness fitness){
        new DeleteFitnessAsyncTask(fitnessDao).execute(fitness);
    }

    public void deleteAllFitness(){
        new DeleteAllFitnessAsyncTask(fitnessDao).execute();
    }

    public LiveData<List<Fitness>> getAllFitness(){
    return allFitnes;
    }

    private static class InsertFitnessAsyncTask extends AsyncTask<Fitness, Void, Void> {
        private FitnessDAO fitnessDao;

        private InsertFitnessAsyncTask(FitnessDAO fitnessDao){
            this.fitnessDao = fitnessDao;
        }

        @Override
        protected Void doInBackground(Fitness... fitness) {
            fitnessDao.insert(fitness[0]);
            return null;
        }
    }

    private static class UpdateFitnessAsyncTask extends AsyncTask<Fitness, Void, Void> {
        private FitnessDAO fitnessDao;

        private UpdateFitnessAsyncTask(FitnessDAO fitnessDao){
            this.fitnessDao = fitnessDao;
        }

        @Override
        protected Void doInBackground(Fitness... fitness) {
            fitnessDao.update(fitness[0]);
            return null;
        }
    }

    private static class DeleteFitnessAsyncTask extends AsyncTask<Fitness, Void, Void> {
        private FitnessDAO fitnessDao;

        private DeleteFitnessAsyncTask(FitnessDAO fitnessDao){
            this.fitnessDao = fitnessDao;
        }

        @Override
        protected Void doInBackground(Fitness... fitness) {
            fitnessDao.delete(fitness[0]);
            return null;
        }
    }

    private static class DeleteAllFitnessAsyncTask extends AsyncTask<Fitness, Void, Void> {
        private FitnessDAO fitnessDao;

        private DeleteAllFitnessAsyncTask(FitnessDAO fitnessDao){
            this.fitnessDao = fitnessDao;
        }

        @Override
        protected Void doInBackground(Fitness... fitness) {
            fitnessDao.deleteAllFitness();
            return null;
        }
    }

}
