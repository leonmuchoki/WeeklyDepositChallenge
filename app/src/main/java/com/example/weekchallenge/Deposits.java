package com.example.weekchallenge;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "deposit_table")
public class Deposits {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "deposit_amount")
    public Double DepositAmount;

    @ColumnInfo(name = "deposit_date")
    public Date DepositDate;

}
