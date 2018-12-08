package com.notes.ayatkhraisat.mvppratctice.di.presenter

import com.notes.ayatkhraisat.mvppratctice.top_rated.TopRatedMoviesPresenter
import com.notes.ayatkhraisat.mvppratctice.top_rated.TopRatedMoviesRepository
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    internal fun provideTopRatedMoviesPresenter(topRatedMoviesRepository: TopRatedMoviesRepository):
            TopRatedMoviesPresenter {
        return TopRatedMoviesPresenter(topRatedMoviesRepository)
    }
}
