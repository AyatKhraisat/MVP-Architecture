package com.ayatkhraisat.mvp_example.top_rated

import com.ayatkhraisat.mvp_example.di.scopes.ViewScope
import com.ayatkhraisat.mvp_example.models.Model
import javax.inject.Inject


@ViewScope
class TopRatedMoviesPresenter @Inject constructor(val repository: TopRatedMoviesRepository)
    : TopRatedMoviesContract.ActionsListener,
     TopRatedMoviesContract.Repo {

     lateinit var view : TopRatedMoviesContract.View

    init {

        loadMoviesList()
    }
    override fun onLoadMoviesFails() {

    }


    override fun onLoadMoviesSuccess(moviesList: ArrayList<Model.MovieItem>) {
        view.showMoviesList(moviesList)
    }




    fun attachView(topRatedMoviesContractView: TopRatedMoviesContract.View) {
        view = topRatedMoviesContractView
        }
        override fun loadMoviesList() {

            repository.getTopRatedMovies(this)


        }


        override fun openMovieDetails() {

        }


    }