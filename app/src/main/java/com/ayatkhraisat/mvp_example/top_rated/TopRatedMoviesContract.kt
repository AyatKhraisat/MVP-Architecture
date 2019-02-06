package com.ayatkhraisat.mvp_example.top_rated

import androidx.paging.PagedList
import com.ayatkhraisat.mvp_example.base.BaseContract
import com.ayatkhraisat.mvp_example.models.Model

interface TopRatedMoviesContract {


    interface ActionsListener<T :BaseContract.BaseView>  {
        fun openMovieDetails();

    }


    interface View :BaseContract.BaseView {
        fun showMoviesList(list :PagedList<Model.MovieItem>)
        fun showMoviesDetails()
    }

}