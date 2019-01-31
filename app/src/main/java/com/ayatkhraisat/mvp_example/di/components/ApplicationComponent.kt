package com.ayatkhraisat.mvp_example.di.components

import android.content.Context
import com.ayatkhraisat.mvp_example.App
import com.ayatkhraisat.mvp_example.di.modules.ApplicationModule
import com.ayatkhraisat.mvp_example.di.modules.NetworkModule
import com.ayatkhraisat.mvp_example.di.qualifires.ApplicationContext
import com.ayatkhraisat.mvp_example.network.MoviesService
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ayat Khriasat on 14,December,2018 at 7:33 PM
 * Email: ayatzkhraisat@gmail.com
 * Project: MvpExample
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface ApplicationComponent {

    fun inject(application: App)

    @ApplicationContext
    fun getApplication(): Context

    fun getNetworkService(): MoviesService

}
