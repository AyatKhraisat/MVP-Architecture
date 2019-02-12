package com.ayatkhraisat.mvp_example.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.ayatkhraisat.mvp_example.models.Model
import javax.inject.Inject

/**
 * Created by Ayat khraisat  on 2/12/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */
class DataSourceFactory @Inject constructor(private val moviesDataSource: MoviesDataSource) :
    DataSource.Factory<Int, Model.MovieItem>() {

    val mutableLiveData: MutableLiveData<MoviesDataSource>

    init {
        this.mutableLiveData = MutableLiveData()
    }


    override fun create(): DataSource<Int, Model.MovieItem> {

        mutableLiveData.postValue(moviesDataSource)

        return moviesDataSource
    }

}
