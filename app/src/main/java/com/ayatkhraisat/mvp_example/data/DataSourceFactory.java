package com.ayatkhraisat.mvp_example.data;


import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.ayatkhraisat.mvp_example.network.MoviesService;

import javax.inject.Inject;

/**
 * Created by Ayat khraisat  on 2/6/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */
public class DataSourceFactory extends DataSource.Factory {

    private MoviesService moviesService;

    private MutableLiveData<MoviesDataSource> mutableLiveData;

    private MoviesDataSource moviesDataSource;

    @Inject
    DataSourceFactory(MoviesService moviesService) {
        this.moviesService = moviesService;
        this.mutableLiveData = new MutableLiveData<>();
    }


    @Override
    public DataSource create() {

        moviesDataSource = new MoviesDataSource(moviesService);

        mutableLiveData.postValue(moviesDataSource);

       return moviesDataSource;
    }


    public MutableLiveData<MoviesDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

}
