package com.ayatkhraisat.mvp_example


import android.app.Application
import com.ayatkhraisat.mvp_example.di.components.ApplicationComponent
import com.ayatkhraisat.mvp_example.di.components.DaggerApplicationComponent
import com.ayatkhraisat.mvp_example.di.modules.ApplicationModule
import com.ayatkhraisat.mvp_example.di.modules.NetworkModule

class App : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .networkModule(NetworkModule("https://api.themoviedb.org/"))
            .applicationModule(ApplicationModule(this)).build()
    }


}
