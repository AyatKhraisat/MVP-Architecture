package com.ayatkhraisat.mvp_example.main

import androidx.paging.PagedList
import com.ayatkhraisat.mvp_example.base.BaseContract
import com.ayatkhraisat.mvp_example.models.Model

/**
 * Created by Ayat khraisat  on 1/31/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */
interface MainContract {


    interface MainView  {
        fun showMoviesList(list : PagedList<Model.MovieItem>)
        fun showMoviesDetails()
    }

    interface MainActions {
        fun openMovieDetails();
    }
}