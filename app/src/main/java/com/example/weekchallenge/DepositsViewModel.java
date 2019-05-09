package com.example.weekchallenge;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DepositsViewModel extends AndroidViewModel {
    private DepositRepository mRepository;
    private LiveData<List<Deposits>> mAllDeposits;

    public DepositsViewModel (Application application) {
        super(application);
        mRepository = new DepositRepository(application);
        mAllDeposits = mRepository.getAllDeposits();
    }

    LiveData<List<Deposits>> getAllDeposits() { return mAllDeposits; }

    public void insert(Deposits deposit) { mRepository.insert(deposit); }
}
