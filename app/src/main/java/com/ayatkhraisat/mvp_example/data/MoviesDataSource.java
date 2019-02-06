package com.ayatkhraisat.mvp_example.data;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import com.ayatkhraisat.mvp_example.models.Model;
import com.ayatkhraisat.mvp_example.network.MoviesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by Ayat khraisat  on 2/6/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */
public class MoviesDataSource extends PageKeyedDataSource<Integer,Model.MovieItem> {

    private MoviesService moviesService;

    @Inject
    MoviesDataSource(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer,Model.MovieItem> callback) {

        moviesService.getTopRatedMovies("a88fdea6e9d79ea3b06d8f065ca3a005", 1)
                .enqueue(new Callback<Model.MoviesList>() {
                    @Override
                    public void onResponse(Call<Model.MoviesList> call, Response<Model.MoviesList> response) {
                        if (response.isSuccessful()) {
                            callback.onResult(response.body().getResults(), null, 2);

                        } else {
//                            initialLoading.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
//                            networkState.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Model.MoviesList> call, Throwable t) {

                    }

                });
    }

    @Override
    public void loadBefore
            (@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Model.MovieItem> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Model.MovieItem> callback) {

        moviesService.getTopRatedMovies("a88fdea6e9d79ea3b06d8f065ca3a005", params.key)
                .enqueue(new Callback<Model.MoviesList>() {
                    @Override
                    public void onResponse(Call<Model.MoviesList> call, Response<Model.MoviesList> response) {
                        if (response.isSuccessful()) {
                            int nextKey = (params.key == response.body().getTotalPages()) ? null : params.key+1;
                            callback.onResult(response.body().getResults(),nextKey);

                        } else {
//                            initialLoading.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
//                            networkState.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Model.MoviesList> call, Throwable t) {

                    }

                });
    }
}
