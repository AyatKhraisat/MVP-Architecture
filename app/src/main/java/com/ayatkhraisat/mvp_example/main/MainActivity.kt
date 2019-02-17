package com.ayatkhraisat.mvp_example.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ayatkhraisat.mvp_example.base.BaseActivity
import com.ayatkhraisat.mvp_example.models.Model
import com.notes.ayatkhraisat.mvp_example.R
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject

class MainActivity : BaseActivity(),MainContract.MainView {


    @Inject
    lateinit var presenter: TopRatedMoviesPresenter

    @Inject
    lateinit var adapter: TopRatedMoviesAdapter


    override fun inject() {
        viewComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        attachPresenter()
        initViews()
        presenter.getPagedList().observe(this, Observer { adapter.submitList(it) })

    }


    private fun initViews() {
        rv_movies.adapter = adapter
    }

    private fun attachPresenter() {
        presenter.onAttach(this)
    }

    override fun showMoviesList(list: PagedList<Model.MovieItem>) {
        adapter.submitList(list)
    }

    override fun showMoviesDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
