package com.notes.ayatkhraisat.mvppratctice.top_rated

import com.bumptech.glide.Glide.init
import com.notes.ayatkhraisat.mvppratctice.models.Model


public class TopRatedMoviesPresenter(val repository: TopRatedMoviesRepository,
                                     val view: TopRatedMoviesContract.View)
    : TopRatedMoviesContract.ActionsListener,TopRatedMoviesContract.Repo {
    override fun onLoadMoviesFails() {

    }


    override fun onLoadMoviesSuccess(moviesList : ArrayList<Model.MovieItem>) {
        view.showMoviesList(moviesList)
    }


    init {

        loadMoviesList()
    }

    override fun loadMoviesList() {

        repository.getTopRatedMovies(this)


    }

    override fun openMovieDetails() {

    }


}