package com.ayatkhraisat.mvp_example.top_rated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.notes.ayatkhraisat.mvp_example.R
import com.notes.ayatkhraisat.mvp_example.databinding.MovieItemBinding
import com.ayatkhraisat.mvp_example.models.Model




class TopRatedMoviesAdapter( val  moviesList: ArrayList<Model.MovieLocalItem>)
    : RecyclerView.Adapter<TopRatedMoviesAdapter.ViewHolder>() {



    private lateinit var binding: MovieItemBinding


    class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding =
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.movie_item, parent, false
                );

        return ViewHolder(binding);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.movie= this.moviesList!!.get(position)

    }



    override fun getItemCount(): Int {

        moviesList?.let { return moviesList.size }
        return 0;
    }

}
