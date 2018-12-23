package com.ayatkhraisat.mvp_example.top_rated

import android.util.Log
import com.ayatkhraisat.mvp_example.data.room.MovieDao
import com.ayatkhraisat.mvp_example.models.Model
import com.ayatkhraisat.mvp_example.models.convertToLocal
import com.ayatkhraisat.mvp_example.network.MoviesService
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TopRatedMoviesRepository @Inject  constructor(val endPoint: MoviesService, val movieDao: MovieDao) {



    internal fun getTaskItemModels(): Observable<List<Model.MovieLocalItem>> {


        return Observable.concat<List<Model.MovieLocalItem>>(
            getTaskItemModelsFromDb(),
            getTaskItemModelsFromApi()
        )

    }


    private fun getTaskItemModelsFromDb(): Observable<List<Model.MovieLocalItem>> {
        return movieDao.getAll().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
            .toObservable().doOnNext({ taskItemLocalModels ->
                Log.d(
                    "threads: ", taskItemLocalModels.size.toString()
                )
            }).doOnError({ throwable ->
                Log.d(
                    "threads: ",
                    (throwable.message + " error").toString()
                )
            })

    }


    private fun getTaskItemModelsFromApi(): Observable<List<Model.MovieLocalItem>> {
        return endPoint.getTopRatedMovies("a88fdea6e9d79ea3b06d8f065ca3a005").flatMap { list ->
            Observable.fromIterable(list.results)
                .observeOn(AndroidSchedulers.mainThread())
                .map({ item -> item.convertToLocal() })
                .toList()
                .toObservable().doOnNext({ this.storeTaskItemModelsInDb(it) })
        }.subscribeOn(Schedulers.io())


    }


    private fun storeTaskItemModelsInDb(taskItemModels: List<Model.MovieLocalItem>) {
        Completable.fromAction { movieDao.saveAll(taskItemModels) }
            .subscribeOn(Schedulers.io())
            .subscribe()

    }
}
