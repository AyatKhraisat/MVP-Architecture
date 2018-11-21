package com.notes.ayatkhraisat.mvppratctice.top_rated


public class TopRatedMoviesPresenter(val repository: TopRatedMoviesRepository,
                                     val view: TopRatedMoviesContract.View) : TopRatedMoviesContract.ActionsListener {



    init {

        loadMoviesList()
    }

    override fun loadMoviesList() {

       view.showMoviesList(repository.getTopRatedMovies())
    }

    override fun openMovieDetails() {

    }


}