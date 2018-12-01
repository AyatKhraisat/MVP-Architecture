package com.notes.ayatkhraisat.mvppratctice.top_rated

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.notes.ayatkhraisat.mvppratctice.R
import com.notes.ayatkhraisat.mvppratctice.databinding.ActivityMoviesListBinding
import com.notes.ayatkhraisat.mvppratctice.models.Model

class TopRatedMoviesActivity : AppCompatActivity(), TopRatedMoviesContract.View {



    private lateinit var repository : TopRatedMoviesRepository
    private lateinit var presenter: TopRatedMoviesPresenter
    private lateinit var moviesListBinding: ActivityMoviesListBinding





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moviesListBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_movies_list
        )
        repository=TopRatedMoviesRepository(this)
        presenter =TopRatedMoviesPresenter(repository,this)

        presenter.loadMoviesList()

    }

    override fun showMoviesDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showMoviesList(list: ArrayList<Model.MovieItem>) {
        moviesListBinding.invalidateAll()

        moviesListBinding.rvMovies.layoutManager= LinearLayoutManager(this)
        moviesListBinding.rvMovies.adapter=TopRatedMoviesAdapter(list)

    }


}


