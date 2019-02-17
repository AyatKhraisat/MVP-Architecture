package com.ayatkhraisat.mvp_example.data.room

import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ayat khraisat  on 2/7/19
 * akhraisat@blessedtreeit.com
 *
 *
 * Project Name: MVP_Architecture
 *
 *
 * Blessed Tree IT
 */
@Singleton
class SharedPreferencesHelper @Inject
constructor(context: Context) {

    private val sharedPreferences: SharedPreferences

    companion object {
        protected val USER_PREFERENCES_FILE_KEY = "user_file"
    }

    init {

        sharedPreferences = context.getSharedPreferences(USER_PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)
    }


    var pageNumber: Int
        get() = sharedPreferences.getInt("Page", 1)
        set(pageId) = sharedPreferences.edit()
            .putInt("Page", pageId).apply()




}
