package com.ayatkhraisat.mvp_example.top_rated;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.ayatkhraisat.mvp_example.base.BasePresenter;
import com.ayatkhraisat.mvp_example.data.DataSourceFactory;
import com.ayatkhraisat.mvp_example.models.Model;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Ayat khraisat  on 2/6/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */
public class TopRatedMoviesPresenter extends BasePresenter<TopRatedMoviesFragment> implements
        TopRatedMoviesContract.ActionsListener<TopRatedMoviesFragment> {

    private DataSourceFactory moviesDataSource;
    private Executor executor;
    private LiveData<PagedList<Model.MovieItem>> pagedList;

    @Inject
    TopRatedMoviesPresenter(DataSourceFactory moviesDataSource) {

        this.moviesDataSource = moviesDataSource;
    }

    @Override
    public void onAttach(@NotNull TopRatedMoviesFragment view) {
        super.onAttach(view);
        loadMoviesList();
    }

    private void loadMoviesList() {

        executor = Executors.newFixedThreadPool(5);
//
//        networkState = Transformations.switchMap(feedDataFactory.getMutableLiveData(),
//            dataSource -> dataSource.getNetworkState());

        PagedList.Config pagedListConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(20)
                .setPageSize(10).build();

        pagedList = (new LivePagedListBuilder(moviesDataSource, pagedListConfig))
                .setFetchExecutor(executor)
                .build();


    }

    public LiveData<PagedList<Model.MovieItem>> getPagedList() {
        return pagedList;
    }

    @Override
    public void openMovieDetails() {

    }
}