package com.ayatkhraisat.mvp_example.top_rated

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayatkhraisat.mvp_example.base.BaseActivity
import com.ayatkhraisat.mvp_example.models.Model
import com.notes.ayatkhraisat.mvp_example.R
import kotlinx.android.synthetic.main.activity_movies_list.*
import javax.inject.Inject

class TopRatedMoviesActivity : BaseActivity(), TopRatedMoviesContract.View {

    @Inject
    lateinit var presenter: TopRatedMoviesPresenter

    @Inject
    lateinit var adapter: TopRatedMoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewComponent()
        setContentView(R.layout.activity_movies_list)
        attachPresenter()
        initViews()
    }

    private fun initViews() {
        rv_movies.adapter = adapter
        rv_movies.layoutManager = LinearLayoutManager(this)

    }

    private fun attachPresenter() {
        presenter.onAttach(this)
    }

    private fun initViewComponent() {
        getViewComponent().inject(this)
    }

    override fun showMoviesDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showMoviesList(list: ArrayList<Model.MovieItem?>?) {
        adapter.setMoviesList(list)
    }


}


