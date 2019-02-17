package com.ayatkhraisat.mvp_example.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.ayatkhraisat.mvp_example.models.Model
import com.ayatkhraisat.mvp_example.network.MoviesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


/**
 * Created by Ayat khraisat  on 2/12/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */

const val API_KEY = "a88fdea6e9d79ea3b06d8f065ca3a005"

class MoviesDataSource @Inject constructor(val moviesService: MoviesService) :
    PageKeyedDataSource<Int, Model.MovieItem>() {


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Model.MovieItem>) {
        moviesService.getTopRatedMovies(API_KEY, 1)
            .enqueue(object : Callback<Model.MoviesList> {
                override fun onResponse(call: Call<Model.MoviesList>, response: Response<Model.MoviesList>) {
                    if (response.isSuccessful) {
                        callback.onResult(response.body()!!.results, null, 2)

                    } else {
                        Log.e(javaClass.simpleName, "${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<Model.MoviesList>, t: Throwable) {
                    Log.e(javaClass.simpleName, "Error: ${t.message}")
                }

            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Model.MovieItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Model.MovieItem>) {


        moviesService.getTopRatedMovies(API_KEY, params.key)
            .enqueue(object : Callback<Model.MoviesList> {
                override fun onResponse(call: Call<Model.MoviesList>, response: Response<Model.MoviesList>) {
                    if (response.isSuccessful) {
                        val nextKey = if (params.key == response.body()!!.totalPages) null else params.key + 1
                        callback.onResult(response.body()!!.results, nextKey)

                    } else {
                        Log.e(javaClass.simpleName, "${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<Model.MoviesList>, t: Throwable) {
                    Log.e(javaClass.simpleName, "Error: ${t.message}")
                }

            })
    }
}
