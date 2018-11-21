package com.notes.ayatkhraisat.mvppratctice.top_rated

import android.content.Context
import com.notes.ayatkhraisat.mvppratctice.models.Model
import com.notes.ayatkhraisat.mvppratctice.network.MoviesService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

public class TopRatedMoviesRepository constructor(context: Context) {



    fun getTopRatedMovies():ArrayList<Model.MovieItem>{

        var moviesList = ArrayList<Model.MovieItem>();
         MoviesService.create().getTopRatedMovies("a88fdea6e9d79ea3b06d8f065ca3a005")
             .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .subscribe(
                {
                    moviesList = it.results as ArrayList<Model.MovieItem> },
                {

                }
            ).dispose();

        return moviesList;

    }

}