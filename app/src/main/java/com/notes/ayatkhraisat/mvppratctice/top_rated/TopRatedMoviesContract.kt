package com.notes.ayatkhraisat.mvppratctice.top_rated

interface TopRatedMoviesContract {


    interface ActionsListener {
        fun loadMoviesList()
        fun openMovieDetails();
    }


    interface View {
        fun showMoviesList()
        fun showMoviesDetails()
    }

}