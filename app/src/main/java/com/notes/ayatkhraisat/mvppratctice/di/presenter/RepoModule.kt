package com.notes.ayatkhraisat.mvppratctice.di.presenter

import com.notes.ayatkhraisat.mvppratctice.top_rated.TopRatedMoviesRepository
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(): TopRatedMoviesRepository {
        return TopRatedMoviesRepository()
    }
}
