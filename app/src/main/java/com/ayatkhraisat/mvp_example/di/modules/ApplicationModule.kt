package com.ayatkhraisat.mvp_example.di.modules

import android.content.Context
import com.ayatkhraisat.mvp_example.data.room.SharedPreferencesHelper
import com.ayatkhraisat.mvp_example.di.qualifires.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ayat Khriasat on 14,December,2018 at 7:33 PM
 * Email: ayatzkhraisat@gmail.com
 * Project: MvpExample
 */
@Module
class ApplicationModule(val application: Context) {


    @Singleton
    @ApplicationContext
    @Provides
    fun provideApplicationContext(): Context = application


    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext application: Context): SharedPreferencesHelper = SharedPreferencesHelper(application);


}
