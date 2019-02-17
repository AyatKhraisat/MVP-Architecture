package com.ayatkhraisat.mvp_example.top_rated

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ayatkhraisat.mvp_example.base.BasePresenter
import com.ayatkhraisat.mvp_example.data.room.MovieDao
import com.ayatkhraisat.mvp_example.main.TopRatedMoviesActivity
import com.ayatkhraisat.mvp_example.main.TopRatedMoviesContract
import com.ayatkhraisat.mvp_example.models.Model
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiConsumer
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by Ayat khraisat  on 2/6/19
 * akhraisat@blessedtreeit.com
 *
 *
 * Project Name: MVP_Architecture
 *
 *
 * Blessed Tree IT
 */
class TopRatedMoviesPresenter @Inject
internal constructor(private val topRatedMoviesRepository: TopRatedMoviesRepository, private val movieDao: MovieDao) :
    BasePresenter<TopRatedMoviesActivity>(), TopRatedMoviesContract.TopRatedMoviesActions {

    private var executor: Executor? = null
    lateinit var pagedList: LiveData<PagedList<Model.MovieItem>>
        private set

    private var lastRequestedPage: Int = 0
    private val ioExecutor: Executor? = null

    init {
        lastRequestedPage = 1
    }

    override fun onAttach(view: TopRatedMoviesActivity) {
        super.onAttach(view)
        loadMoviesList()
    }

    private fun loadMoviesList() {

        executor = Executors.newFixedThreadPool(5)

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(20)
            .setPageSize(10).build()

        val integerMovieItemDataSource = movieDao.all
        pagedList = LivePagedListBuilder(integerMovieItemDataSource, pagedListConfig)
            .setFetchExecutor(executor!!)
            .setBoundaryCallback(object : PagedList.BoundaryCallback<Model.MovieItem>() {
                override fun onZeroItemsLoaded() {
                    super.onZeroItemsLoaded()
                    lastRequestedPage = 1

                    loadData(lastRequestedPage)
                }

                override fun onItemAtEndLoaded(itemAtEnd: Model.MovieItem) {
                    super.onItemAtEndLoaded(itemAtEnd)
                    loadData(++lastRequestedPage)
                }

            })
            .build()
    }


    private fun loadData(index: Int) {
        getCompositeDisposable().add(
            topRatedMoviesRepository.getTopRatedMovies(index)
                .subscribe(
                    { Log.d(javaClass.name, "saved to database!") },
                    { Log.e(javaClass.name, "Something went wrong will saving to database") })
        )

    }

    override fun openMovieDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}