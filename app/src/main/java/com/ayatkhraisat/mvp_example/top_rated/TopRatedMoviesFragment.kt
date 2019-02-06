package com.ayatkhraisat.mvp_example.top_rated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.ayatkhraisat.mvp_example.base.BaseActivity
import com.ayatkhraisat.mvp_example.base.BaseFragment
import com.ayatkhraisat.mvp_example.models.Model
import com.notes.ayatkhraisat.mvp_example.R
import javax.inject.Inject

class TopRatedMoviesFragment : BaseFragment(), TopRatedMoviesContract.View {


    override fun toastLong(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toastShort(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var presenter: TopRatedMoviesPresenter

    @Inject
    lateinit var adapter: TopRatedMoviesAdapter

    lateinit var moviesRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.activity_movies_list, container, false)

        moviesRecyclerView = rootView.findViewById(R.id.rv_movies)

        attachPresenter()
        initViews()
        presenter.getPagedList().observe(this, Observer {   adapter.submitList(it)  })

        return rootView
    }

    private fun initViews() {
        moviesRecyclerView.adapter = adapter
    }

    private fun attachPresenter() {
        presenter.onAttach(this)
    }


    override fun showMoviesDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun inject(base: BaseActivity) {
        base.viewComponent.inject(this)
    }

    override fun showMoviesList(list: PagedList<Model.MovieItem>) {
        adapter.submitList(list)
    }



}


