package com.ayatkhraisat.mvp_example.di.modules

import android.content.Context
import com.ayatkhraisat.mvp_example.base.BaseActivity
import com.ayatkhraisat.mvp_example.data.room.DatabaseHolder
import com.ayatkhraisat.mvp_example.data.room.MovieDao
import com.ayatkhraisat.mvp_example.di.scopes.ActivityContext
import com.ayatkhraisat.mvp_example.di.scopes.ViewScope
import com.ayatkhraisat.mvp_example.main.MainActivity
import com.ayatkhraisat.mvp_example.main.MainContract
import com.ayatkhraisat.mvp_example.main.MainPresenter
import com.ayatkhraisat.mvp_example.network.MoviesService
import com.ayatkhraisat.mvp_example.top_rated.*
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Ayat khraisat  on 12/23/18
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVPPractice
 * <p>
 * Blessed Tree IT
 */
@Module
class ActivityModule(val context: Context) {

    @Provides
    @ActivityContext
    internal fun provideContext(): Context {
        return context
    }


    @Provides
    @ViewScope
    internal fun provideTasksDao(): MovieDao {
        return DatabaseHolder.getDatabaseInstance(context).taskDao()

    }

    @Provides
    @ViewScope
    internal fun provideMoviesRepository(
        movieDao: MovieDao, moviesService: MoviesService
    ): TopRatedMoviesRepository {
        return TopRatedMoviesRepository(moviesService, movieDao)
    }


    @Provides
    @ViewScope
    internal fun provideTaskView(topRatedMovieView: TopRatedMoviesFragment): TopRatedMoviesContract.View {
        return topRatedMovieView
    }

    @Provides
    @ViewScope
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }


    @Provides
    @ViewScope
    internal fun provideTasksPresenter(
        view: TopRatedMoviesContract.View,
        compositeDisposable: CompositeDisposable,
        topRatedMoviesRepository: TopRatedMoviesRepository
    ): TopRatedMoviesContract.Presenter {
        return TopRatedMoviesPresenter(topRatedMoviesRepository, view, compositeDisposable)
    }

    @Provides
    @ViewScope
    internal fun provideMainView(@ActivityContext context: Context): MainContract.MainView {
        return context as MainContract.MainView
    }


    @Provides
    @ViewScope
    internal fun provideMainPresenter(view: MainContract.MainView): MainPresenter {
        return MainPresenter(view)
    }


    @Provides
    @ViewScope
    internal fun provideBaseActivity(@ActivityContext context: Context): BaseActivity {
        return context as BaseActivity
    }


    @Provides
    @ViewScope
    internal fun provideTasksFragment(): TopRatedMoviesFragment {
        return TopRatedMoviesFragment()
    }


//
//    @Provides
//    @ViewScope
//    internal fun provideTasksAdapter(): TopRatedMoviesAdapter {
//        return TopRatedMoviesAdapter(Mov)
//    }


}
