package com.notes.ayatkhraisat.mvppratctice.di.presenter


import com.notes.ayatkhraisat.mvppratctice.base.BaseActivity
import com.notes.ayatkhraisat.mvppratctice.base.BasePresenter
import com.notes.ayatkhraisat.mvppratctice.top_rated.TopRatedMoviesActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(PresenterModule::class))
interface PresenterCompontent {

    fun inject(topActivity: TopRatedMoviesActivity)
}
