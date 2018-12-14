package com.ayatkhraisat.mvp_example.top_rated

import android.util.Log
import com.ayatkhraisat.mvp_example.models.Model
import com.ayatkhraisat.mvp_example.network.MoviesService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TopRatedMoviesRepository  constructor(val moviesService: MoviesService) {


    fun getTopRatedMovies(listener: TopRatedMoviesContract.Repo) {
        var moviesList = ArrayList<Model.MovieItem>();

        moviesService.getTopRatedMovies("a88fdea6e9d79ea3b06d8f065ca3a005")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.e("Ayat", "${it.totalPages}")
                    moviesList = it.results as ArrayList<Model.MovieItem>
                    listener.onLoadMoviesSuccess(moviesList)
                },
                {
                    Log.e("Ayat", it.localizedMessage)
                    listener.onLoadMoviesFails()
                }
            )


    }

}