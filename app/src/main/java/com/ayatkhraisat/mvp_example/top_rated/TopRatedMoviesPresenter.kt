package com.ayatkhraisat.mvp_example.top_rated

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ayatkhraisat.mvp_example.base.BasePresenter
import com.ayatkhraisat.mvp_example.data.DataSourceFactory
import com.ayatkhraisat.mvp_example.models.Model
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

/**
 * Created by Ayat khraisat  on 2/12/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 * Blessed Tree IT
 */
class TopRatedMoviesPresenter
@Inject constructor(val moviesDataSource: DataSourceFactory)
    : BasePresenter<TopRatedMoviesFragment>(),
    TopRatedMoviesContract.ActionsListener<TopRatedMoviesFragment> {

    private var executor: Executor? = null
    private lateinit var pagedList: LiveData<PagedList<Model.MovieItem>>


    override fun onAttach(view: TopRatedMoviesFragment) {
        super.onAttach(view)
        loadMoviesList()
    }

    private fun loadMoviesList() {

        executor = Executors.newFixedThreadPool(5)

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(20)
            .setPageSize(10).build()

        pagedList = LivePagedListBuilder(moviesDataSource, pagedListConfig)
            .setFetchExecutor(executor!!)
            .build()



    }

    fun getPagedList(): LiveData<PagedList<Model.MovieItem>> {
        return pagedList
    }

    override fun openMovieDetails() {

    }
}