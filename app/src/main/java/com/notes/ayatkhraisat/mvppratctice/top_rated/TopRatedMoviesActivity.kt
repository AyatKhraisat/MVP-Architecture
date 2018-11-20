package com.notes.ayatkhraisat.mvppratctice.top_rated

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.notes.ayatkhraisat.mvppratctice.R
import com.notes.ayatkhraisat.mvppratctice.databinding.ActivityMoviesListBinding

class TopRatedMoviesActivity : AppCompatActivity(), TopRatedMoviesContract.View {


    private lateinit var presenter: TopRatedMoviesPresenter
    private lateinit var moviesListBinding: ActivityMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moviesListBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_movies_list
        )
        presenter = TopRatedMoviesPresenter()


    }

    override fun showMoviesDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMoviesList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


