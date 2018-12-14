package com.ayatkhraisat.mvp_example.di.modules

import com.ayatkhraisat.mvp_example.di.scopes.ViewScope
import com.ayatkhraisat.mvp_example.network.MoviesService
import com.ayatkhraisat.mvp_example.top_rated.TopRatedMoviesRepository
import dagger.Module
import dagger.Provides

import javax.inject.Singleton
/**
 * Created by Ayat Khriasat on 14,December,2018 at 7:33 PM
 * Email: ayatzkhraisat@gmail.com
 * Project: MvpExample
 */
@Module
class RepoModule {

    @Provides
    @ViewScope
    fun provideMoviesRepository(moviesService: MoviesService): TopRatedMoviesRepository {
        return TopRatedMoviesRepository(moviesService)
    }
}
