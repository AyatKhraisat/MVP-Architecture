package com.notes.ayatkhraisat.mvppratctice.top_rated

import com.notes.ayatkhraisat.mvppratctice.models.Model

interface TopRatedMoviesContract {


    interface ActionsListener {
        fun loadMoviesList()
        fun openMovieDetails();
    }


    interface View {
        fun showMoviesList(list :ArrayList<Model.MovieItem>)
        fun showMoviesDetails()
    }

}