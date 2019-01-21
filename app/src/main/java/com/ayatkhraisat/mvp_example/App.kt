package com.ayatkhraisat.mvp_example


import android.app.Application
import com.ayatkhraisat.mvp_example.di.components.ApplicationComponent
import com.ayatkhraisat.mvp_example.di.components.DaggerApplicationComponent
import com.ayatkhraisat.mvp_example.di.modules.ApplicationModule
import com.ayatkhraisat.mvp_example.di.modules.NetworkModule

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        applicationComponent =
                DaggerApplicationComponent.builder()
                    .networkModule(NetworkModule("https://api.themoviedb.org/"))
                    .applicationModule(ApplicationModule(this)).build()
    }
}
