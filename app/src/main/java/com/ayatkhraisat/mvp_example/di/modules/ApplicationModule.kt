package com.ayatkhraisat.mvp_example.di.modules

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide.init
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ayat Khriasat on 14,December,2018 at 7:33 PM
 * Email: ayatzkhraisat@gmail.com
 * Project: MvpExample
 */
@Module
class ApplicationModule(val application: Application) {


    @Singleton
    @Provides
    fun  provideApplicationContext(): Context = application

}
