package com.notes.ayatkhraisat.mvppratctice.network

import com.notes.ayatkhraisat.mvppratctice.models.Model
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface MoviesService {

    companion object {
        fun create(): MoviesService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .build()

            return retrofit.create(MoviesService::class.java)
        }
    }

    fun getTopRatedMovies(@Query("api_key") apiKey: String): Single<Model.MoviesList>

}