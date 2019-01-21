package com.ayatkhraisat.mvp_example.top_rated

import android.util.Log
import com.ayatkhraisat.mvp_example.base.BasePresenter
import com.ayatkhraisat.mvp_example.models.Model
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class TopRatedMoviesPresenter @Inject constructor(val repository: TopRatedMoviesRepository) :
    TopRatedMoviesContract.ActionsListener<TopRatedMoviesActivity>, BasePresenter<TopRatedMoviesActivity>() {

    init {

        loadMoviesList()
    }


    private fun loadMoviesList() {

        getCompositeDisposable().add(repository.getTopRatedMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d(javaClass.simpleName, "${it.totalPages}")
                    getView().showMoviesList(it.results)
                },
                {
                    Log.d(javaClass.simpleName, it.localizedMessage)
                }
            ));


    }


    override fun openMovieDetails() {

    }

}