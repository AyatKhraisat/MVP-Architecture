package com.ayatkhraisat.mvp_example.data.room;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Ayat khraisat  on 2/7/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */
@Singleton
public class SharedPreferencesHelper {

    private SharedPreferences sharedPreferences;
    protected static final String USER_PREFRENCES_FILE_KEY = "user_file";

    @Inject
    public SharedPreferencesHelper(Context context) {

        sharedPreferences = context.getSharedPreferences(USER_PREFRENCES_FILE_KEY, Context.MODE_PRIVATE);

    }


    public void setPageNumber(int pageId) {
        sharedPreferences.edit()
                .putInt("Page", pageId).apply();
    }

    public int getPageNumber() {
        return sharedPreferences.getInt("Page", 1);

    }


}
