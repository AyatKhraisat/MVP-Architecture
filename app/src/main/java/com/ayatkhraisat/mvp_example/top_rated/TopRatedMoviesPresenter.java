package com.ayatkhraisat.mvp_example.top_rated;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.ayatkhraisat.mvp_example.base.BasePresenter;
import com.ayatkhraisat.mvp_example.data.room.MovieDao;
import com.ayatkhraisat.mvp_example.models.Model;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
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

//    private DataSourceFactory moviesDataSource;
    private Executor executor;
    private LiveData<PagedList<Model.MovieItem>> pagedList;
    private int lastRequestedPage;
    private TopRatedMoviesRepository topRatedMoviesRepository;

    private  MovieDao movieDao;
    private Executor ioExecutor;

    @Inject
    TopRatedMoviesPresenter(TopRatedMoviesRepository topRatedMoviesRepository, MovieDao movieDao) {

        this.movieDao=movieDao;
        this.topRatedMoviesRepository = topRatedMoviesRepository;
        lastRequestedPage = 1;
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

        DataSource.Factory<Integer, Model.MovieItem> integerMovieItemDataSource = movieDao.getAll();
        pagedList = (new LivePagedListBuilder( integerMovieItemDataSource, pagedListConfig))
                .setFetchExecutor(executor)
                .setBoundaryCallback(new PagedList.BoundaryCallback() {
                    @Override
                    public void onZeroItemsLoaded() {
                        super.onZeroItemsLoaded();
                        lastRequestedPage =1;

                        loadData(lastRequestedPage);
                    }

                    @Override
                    public void onItemAtFrontLoaded(@NonNull Object itemAtFront) {
                        super.onItemAtFrontLoaded(itemAtFront);
                    }

                    @Override
                    public void onItemAtEndLoaded(@NonNull Object itemAtEnd) {
                        super.onItemAtEndLoaded(itemAtEnd);
                        loadData(++lastRequestedPage);
                    }
                })
                .build();



    }

    private void loadData(int index) {
        getCompositeDisposable().add(topRatedMoviesRepository.getTopRatedMovies(index)
                .subscribe(new BiConsumer<Model.MoviesList, Throwable>() {
                               @Override
                               public void accept(Model.MoviesList moviesList, Throwable throwable) throws Exception {
                                   Log.d("saved", "saved ayat");


                               }
                           }
                ));
    }

    public LiveData<PagedList<Model.MovieItem>> getPagedList() {
        return pagedList;
    }

    @Override
    public void openMovieDetails() {

    }
}