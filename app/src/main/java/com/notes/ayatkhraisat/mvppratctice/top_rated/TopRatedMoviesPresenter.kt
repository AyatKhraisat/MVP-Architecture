package com.notes.ayatkhraisat.mvppratctice.top_rated


public class TopRatedMoviesPresenter(
    val repository: TopRatedMoviesRepository,
    val topRatedView: TopRatedMoviesContract.View) :TopRatedMoviesContract.ActionsListener {



    override fun loadMoviesList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openMovieDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}