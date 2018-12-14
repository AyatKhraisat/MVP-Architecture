package com.ayatkhraisat.mvp_example.top_rated

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayatkhraisat.mvp_example.App
import com.ayatkhraisat.mvp_example.base.BaseActivity
import com.notes.ayatkhraisat.mvp_example.R
import com.notes.ayatkhraisat.mvp_example.databinding.ActivityMoviesListBinding
import com.ayatkhraisat.mvp_example.models.Model
import javax.inject.Inject

class TopRatedMoviesActivity : BaseActivity(), TopRatedMoviesContract.View {



    @Inject
    lateinit var repository: TopRatedMoviesRepository
    @Inject
    lateinit var presenter: TopRatedMoviesPresenter

    private lateinit var moviesListBinding: ActivityMoviesListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moviesListBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_movies_list
        )
        viewComponent.inject(this)




      presenter.attachView(this)
        presenter.loadMoviesList()

    }

    override fun showMoviesDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun showMoviesList(list: ArrayList<Model.MovieItem>) {
        moviesListBinding.invalidateAll()

        moviesListBinding.rvMovies.layoutManager = LinearLayoutManager(this)
        moviesListBinding.rvMovies.adapter = TopRatedMoviesAdapter(list)

    }


}


