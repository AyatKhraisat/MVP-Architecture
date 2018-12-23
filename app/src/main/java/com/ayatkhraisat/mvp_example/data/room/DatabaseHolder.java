package com.ayatkhraisat.mvp_example.data.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Room;

/**
 * Created by Ayat khraisat  on 4/24/2018.
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: BTIT-Dashboards-Android-V2.0
 * <p>
 * Blessed Tree IT
 */
public class DatabaseHolder {
    private static AppDatabase DATABASE_INSTANCE;

    private static final String DATABASE_NAME = "movie-database";


    public static AppDatabase getDatabaseInstance(@NonNull Context context) {

        /*Make the Database a singleton to
         prevent having multiple instances of the database
         opened at the same time.
         */
        if (DATABASE_INSTANCE == null) {
            DATABASE_INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return DATABASE_INSTANCE;
    }

}
