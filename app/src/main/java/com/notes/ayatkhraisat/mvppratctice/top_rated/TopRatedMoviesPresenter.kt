package com.notes.ayatkhraisat.mvppratctice.top_rated

import androidx.annotation.UiThread
import com.bumptech.glide.Glide.init

import com.notes.ayatkhraisat.mvppratctice.models.Model


 class TopRatedMoviesPresenter(val repository: TopRatedMoviesRepository)
    : TopRatedMoviesContract.ActionsListener, TopRatedMoviesContract.Repo {

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