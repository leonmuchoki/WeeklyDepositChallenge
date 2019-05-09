package com.example.weekchallenge;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DepositDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Deposits deposit);

    @Query("Delete from deposit_table")
    void DeleteAll();

    @Query("SELECT * from deposit_table ORDER BY deposit_date ASC")
    LiveData<List<Deposits>> getAllDeposits();
}
