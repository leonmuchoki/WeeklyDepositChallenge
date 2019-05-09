package com.example.weekchallenge;

import android.content.Context;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class DepositWriteReadTest {
    private DepositDao depositDao;
    private DepositRoomDatabase db;

    @Before
    public void createDB(){
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, DepositRoomDatabase.class).build();
        depositDao = db.depositDao();
    }

    @After
    public void closeDB() throws Exception {
        db.close();
    }

    @Test
    public void writeSubItemAndReadInList() throws  Exception {
        Deposits deposit = new Deposits();
        deposit.DepositAmount = 20.5;
        Date _newDate = new Date();
        deposit.DepositDate = _newDate;
        depositDao.insert(deposit);

        LiveData<List<Deposits>> deposits = depositDao.getAllDeposits();
        assertThat(deposits.getValue(),contains(deposit));
    }
}
