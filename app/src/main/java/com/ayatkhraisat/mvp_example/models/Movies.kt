package com.ayatkhraisat.mvp_example.models


import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull


object Model {


    data class MoviesList
        (

        @field:SerializedName("page")
        val page: Int? = null,

        @field:SerializedName("total_pages")
        val totalPages: Int? = null,

        @field:SerializedName("results")
        val results: ArrayList<MovieItem?>? = null,

        @field:SerializedName("total_results")
        val totalResults: Int? = null
    )

    @Entity(tableName = "movie")
    data class MovieItem(
        @field:SerializedName("overview")
        val overview: String? = null,

        @field:SerializedName("original_language")
        val originalLanguage: String? = null,

        @field:SerializedName("original_title")
        val originalTitle: String? = null,

        @field:SerializedName("video")
        val video: Boolean? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("poster_path")
        val posterPath: String? = null,

        @field:SerializedName("backdrop_path")
        val backdropPath: String? = null,

        @field:SerializedName("release_date")
        val releaseDate: String? = null,

        @field:SerializedName("vote_average")
        val voteAverage: Double = 0.0,

        @field:SerializedName("popularity")
        val popularity: Double? = null,

        @PrimaryKey
        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("adult")
        val adult: Boolean? = null,

        @field:SerializedName("vote_count")
        val voteCount: Int? = null,


        @field:SerializedName("page")
        val page: Int? = null

    )

    object DIFF_CALLBACK : DiffUtil.ItemCallback<Model.MovieItem>() {
        override fun areItemsTheSame(@NonNull oldItem: Model.MovieItem, @NonNull newItem: Model.MovieItem): Boolean {
            return oldItem.id === newItem.id
        }

        override fun areContentsTheSame(@NonNull oldItem: Model.MovieItem, @NonNull newItem: Model.MovieItem): Boolean {
            return oldItem.equals(newItem)
        }
    }
}



