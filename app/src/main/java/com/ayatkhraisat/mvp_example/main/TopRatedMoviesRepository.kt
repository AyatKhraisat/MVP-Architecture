package com.ayatkhraisat.mvp_example.top_rated

import android.util.AndroidException
import android.util.Log
import com.ayatkhraisat.mvp_example.data.room.MovieDao
import com.ayatkhraisat.mvp_example.data.room.SharedPreferencesHelper
import com.ayatkhraisat.mvp_example.models.Model
import com.ayatkhraisat.mvp_example.network.MoviesService
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject
import java.util.concurrent.Executor
import java.util.concurrent.Executors

internal class TopRatedMoviesRepository @Inject
constructor(
    private val moviesService: MoviesService, private val movieDao: MovieDao,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) {
    private val API_KEY = ""
    private val ioExecutor: Executor

    init {
        ioExecutor = Executors.newCachedThreadPool()

    }

    fun getTopRatedMovies(page: Int): Single<Model.MoviesList> {

        Log.d("page_number= ", "$page")


        return moviesService.getTopRatedMovies(API_KEY, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { (page1, _, results) ->
                ioExecutor.execute { movieDao.saveAll(results) }
                sharedPreferencesHelper.pageNumber = page1!!
            }

    }

}