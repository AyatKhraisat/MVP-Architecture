package com.notes.ayatkhraisat.mvppratctice.top_rated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.notes.ayatkhraisat.mvppratctice.R
import com.notes.ayatkhraisat.mvppratctice.databinding.MovieItemBinding
import com.notes.ayatkhraisat.mvppratctice.models.Model




class TopRatedMoviesAdapter : RecyclerView.Adapter<TopRatedMoviesAdapter.ViewHolder>() {


    private var moviesList: ArrayList<Model.MovieItem>? = null

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

        holder.binding.movie=moviesList!!.get(position)

    }

    override fun getItemCount(): Int {

        moviesList?.let { return moviesList!!.size }
        return 0;
    }

}
