package com.example.weekchallenge;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Deposits.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class DepositRoomDatabase extends RoomDatabase {
    public abstract  DepositDao depositDao();

    private static DepositRoomDatabase INSTANCE;

    public static DepositRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DepositRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DepositRoomDatabase.class, "deposits_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            //new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>
    {
        private DepositDao depositDao;

        PopulateDbAsync(DepositRoomDatabase idb){
            depositDao = idb.depositDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //populate sample data here

            return null;
        }
    }
}
