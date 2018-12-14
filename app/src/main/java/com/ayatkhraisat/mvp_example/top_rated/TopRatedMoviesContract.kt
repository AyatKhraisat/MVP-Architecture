package com.ayatkhraisat.mvp_example.top_rated

import com.ayatkhraisat.mvp_example.models.Model

interface TopRatedMoviesContract {


    interface ActionsListener {
        fun loadMoviesList()
        fun openMovieDetails();
    }


    interface View {
        fun showMoviesList(list :ArrayList<Model.MovieItem>)
        fun showMoviesDetails()
    }

    interface Repo{
        fun onLoadMoviesSuccess( moviesList :ArrayList<Model.MovieItem> );
        fun onLoadMoviesFails();
    }

}