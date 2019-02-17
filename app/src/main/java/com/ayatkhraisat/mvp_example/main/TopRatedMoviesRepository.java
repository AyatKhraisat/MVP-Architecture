package com.ayatkhraisat.mvp_example.top_rated;

import android.util.AndroidException;
import android.util.Log;
import com.ayatkhraisat.mvp_example.data.room.MovieDao;
import com.ayatkhraisat.mvp_example.data.room.SharedPreferencesHelper;
import com.ayatkhraisat.mvp_example.models.Model;
import com.ayatkhraisat.mvp_example.network.MoviesService;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class TopRatedMoviesRepository {

    private MoviesService moviesService;

    private Executor ioExecutor;
    private MovieDao movieDao;
    private SharedPreferencesHelper sharedPreferencesHelper;

    @Inject
    TopRatedMoviesRepository(MoviesService moviesService, MovieDao movieDao,
                             SharedPreferencesHelper sharedPreferencesHelper) {

        this.movieDao = movieDao;
        this.moviesService = moviesService;
        this.sharedPreferencesHelper = sharedPreferencesHelper;
        ioExecutor = Executors.newCachedThreadPool();

    }

    Single<Model.MoviesList> getTopRatedMovies(int page) {

        Log.d("page_number= ", page + "");

        return moviesService.getTopRatedMovies("a88fdea6e9d79ea3b06d8f065ca3a005", page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("page_number= ",  "");

                    }
                })
                .doOnSuccess(new Consumer<Model.MoviesList>() {
                    @Override
                    public void accept(final Model.MoviesList moviesList) throws Exception {
                        ioExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                movieDao.saveAll(moviesList.getResults());

                            }
                        });
                        sharedPreferencesHelper.setPageNumber(moviesList.getPage());

                    }
                });

    }

}