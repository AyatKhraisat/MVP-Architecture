package com.ayatkhraisat.mvp_example.top_rated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayatkhraisat.mvp_example.App
import com.ayatkhraisat.mvp_example.base.BaseActivity
import com.ayatkhraisat.mvp_example.base.BaseFragment
import com.notes.ayatkhraisat.mvp_example.R
import com.notes.ayatkhraisat.mvp_example.databinding.ActivityMoviesListBinding
import com.ayatkhraisat.mvp_example.models.Model
import javax.inject.Inject

class TopRatedMoviesFragment : BaseFragment(), TopRatedMoviesContract.View {
    override fun showMoviesList(list: ArrayList<Model.MovieLocalItem>) {


        moviesListBinding.invalidateAll()

        moviesListBinding.rvMovies.layoutManager = LinearLayoutManager(context)
        moviesListBinding.rvMovies.adapter = TopRatedMoviesAdapter(list)




    }

    private lateinit var moviesListBinding: ActivityMoviesListBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        moviesListBinding = DataBindingUtil.inflate(inflater,
            R.layout.activity_movies_list,container,false
        )
        val view = moviesListBinding.getRoot()
        //here data must be an instance of the class MarsDataProvider


        val component = activityComponent
        if (component != null) {

            component.inject(this)
        }


        return view

    }

    override fun showMoviesDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




}


