package com.ayatkhraisat.mvp_example.di.components


import com.ayatkhraisat.mvp_example.di.modules.PresenterModule
import com.ayatkhraisat.mvp_example.di.modules.RepoModule
import com.ayatkhraisat.mvp_example.di.scopes.ViewScope
import com.ayatkhraisat.mvp_example.top_rated.TopRatedMoviesActivity
import dagger.Component

/**
 * Created by Ayat Khriasat on 14,December,2018 at 7:33 PM
 * Email: ayatzkhraisat@gmail.com
 * Project: MvpExample
 */

@ViewScope
@Component(
    dependencies = arrayOf(ApplicationComponent::class),
    modules = arrayOf(PresenterModule::class, RepoModule::class)
)
interface ViewComponent {

    fun inject(topRatedMoviesActivity: TopRatedMoviesActivity)
}
