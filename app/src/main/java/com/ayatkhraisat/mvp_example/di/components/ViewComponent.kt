package com.ayatkhraisat.mvp_example.di.components


import com.ayatkhraisat.mvp_example.di.modules.ActivityModule
import com.ayatkhraisat.mvp_example.di.scopes.ViewScope
import com.ayatkhraisat.mvp_example.main.MainActivity
import com.ayatkhraisat.mvp_example.top_rated.TopRatedMoviesFragment
import dagger.Component

/**
 * Created by Ayat Khriasat on 14,December,2018 at 7:33 PM
 * Email: ayatzkhraisat@gmail.com
 * Project: MvpExample
 */

@ViewScope
@Component(
    dependencies = arrayOf(ApplicationComponent::class),
    modules = arrayOf(ActivityModule::class)
)
interface ViewComponent {

    fun inject(topRatedMoviesFragment: TopRatedMoviesFragment)

    fun inject(mainActivity: MainActivity)

}
