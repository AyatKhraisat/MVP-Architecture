package com.ayatkhraisat.mvp_example.network

import com.ayatkhraisat.mvp_example.models.Model
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {


    @GET("/3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Observable<Model.MoviesList>

}