package com.ayatkhraisat.mvp_example.top_rated

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ayatkhraisat.mvp_example.di.qualifires.ActivityContext
import com.ayatkhraisat.mvp_example.models.Model
import com.bumptech.glide.Glide
import com.notes.ayatkhraisat.mvp_example.R
import javax.inject.Inject


class TopRatedMoviesAdapter @Inject constructor(@ActivityContext val context: Context) :
    PagedListAdapter<Model.MovieItem,TopRatedMoviesAdapter.ViewHolder>(Model.MovieItem.DIFF_CALLBACK) {


    private val  moviesList: ArrayList<Model.MovieItem?> = ArrayList()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var avatar: ImageView = itemView.findViewById(R.id.iv_movie_poster)
        var title: TextView = itemView.findViewById(R.id.tv_title)
        var rate: TextView = itemView.findViewById(R.id.tv_rate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(v)

    }


    override fun submitList(pagedList: PagedList<Model.MovieItem>?) {
        super.submitList(pagedList)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movie = getItem(position)

        holder.title.text = movie!!.title
        holder.rate.text = movie.voteAverage.toString()
        Glide.with(context)
            .load(
                "https://image.tmdb.org/t/p/w500${movie.posterPath}"
            )
            .into(holder.avatar)
    }




}


