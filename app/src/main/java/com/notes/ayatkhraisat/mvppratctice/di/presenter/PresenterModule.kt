package com.notes.ayatkhraisat.mvppratctice.di.presenter

import android.preference.PreferenceActivity
import com.bumptech.glide.Glide.init
import com.notes.ayatkhraisat.mvppratctice.base.BaseActivity
import com.notes.ayatkhraisat.mvppratctice.base.BasePresenter
import com.notes.ayatkhraisat.mvppratctice.di.ActivityComponent
import com.notes.ayatkhraisat.mvppratctice.top_rated.TopRatedMoviesActivity
import com.notes.ayatkhraisat.mvppratctice.top_rated.TopRatedMoviesPresenter
import dagger.Provides
import dagger.Subcomponent


@Subcomponent(modules = arrayOf(ActivityComponent::class))
class PresenterModule(val  presenter: TopRatedMoviesPresenter) {


    @Provides
    internal fun providesPresenter(): TopRatedMoviesPresenter {
        return presenter
    }

}
