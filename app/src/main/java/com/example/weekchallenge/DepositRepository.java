package com.example.weekchallenge;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DepositRepository {
    private DepositDao mDepositDao;
    private LiveData<List<Deposits>> mAllDeposits;

    DepositRepository(Application application) {
        DepositRoomDatabase db = DepositRoomDatabase.getDatabase(application);
        mDepositDao = db.depositDao();
        mAllDeposits = mDepositDao.getAllDeposits();
    }

    LiveData<List<Deposits>> getAllDeposits() {
        return mAllDeposits;
    }

    public void insert (Deposits deposit) {
        new insertAsyncTask(mDepositDao).execute(deposit);
    }

    private static class insertAsyncTask extends AsyncTask<Deposits, Void, Void> {

        private DepositDao mAsyncTaskDao;

        insertAsyncTask(DepositDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Deposits... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
