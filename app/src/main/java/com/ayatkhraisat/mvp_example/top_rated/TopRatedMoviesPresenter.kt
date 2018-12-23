package com.ayatkhraisat.mvp_example.top_rated

import android.util.Log
import com.ayatkhraisat.mvp_example.di.scopes.ViewScope
import com.ayatkhraisat.mvp_example.models.Model
import com.bumptech.glide.Glide.init
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


@ViewScope
class TopRatedMoviesPresenter @Inject constructor(
    val repository: TopRatedMoviesRepository,
    val view: TopRatedMoviesContract.View,
    val compositeDisposable: CompositeDisposable)
    : TopRatedMoviesContract.Presenter {


    init {

        loadMoviesList()
    }



    override fun loadMoviesList() {

        compositeDisposable.add(repository.getTaskItemModels()
//            .doOnSubscribe({ disposable -> //view.startRefreshing() })
//            .doOnComplete({ //view.stopRefreshing() })
            .subscribe({ taskItemLocalModels ->
                view.showMoviesList(taskItemLocalModels as ArrayList<Model.MovieLocalItem>)
                Log.d("repostry", "supscripe called ")
            }, { throwable ->
               // view.stopRefreshing()
             //   view.showError("Something went wrong")
            }
            ))

    }

   override fun detachView() {
        compositeDisposable.dispose()

    }

    override fun openMovieDetails() {


    }

}