package com.notes.ayatkhraisat.mvppratctice.top_rated

import android.content.Context
import android.util.Log
import com.notes.ayatkhraisat.mvppratctice.models.Model
import com.notes.ayatkhraisat.mvppratctice.network.MoviesService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

public class TopRatedMoviesRepository constructor() {



    fun getTopRatedMovies( listener:TopRatedMoviesContract.Repo){

        var moviesList = ArrayList<Model.MovieItem>();
         MoviesService.create().getTopRatedMovies("a88fdea6e9d79ea3b06d8f065ca3a005")
             .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.e("Ayat","${it.totalPages}")
                    moviesList = it.results as ArrayList<Model.MovieItem>
                    listener.onLoadMoviesSuccess(moviesList)
                },
                {
                    Log.e("Ayat",it.localizedMessage)
                    listener.onLoadMoviesFails()
                }
            )


    }

}