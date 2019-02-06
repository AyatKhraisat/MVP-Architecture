package com.ayatkhraisat.mvp_example.network

import com.ayatkhraisat.mvp_example.models.Model
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {


    @GET("/3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String, @Query("page") page: Int): Call
    <Model.MoviesList>

}