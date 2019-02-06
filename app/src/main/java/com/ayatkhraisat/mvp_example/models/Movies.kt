package com.ayatkhraisat.mvp_example.models


import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import android.R.id
import androidx.recyclerview.widget.DiffUtil
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

    data class MovieItem (
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

        @field:SerializedName("genre_ids")
        val genreIds: List<Int?>? = null,

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

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("adult")
        val adult: Boolean? = null,

        @field:SerializedName("vote_count")
        val voteCount: Int? = null
    )  {


      object DIFF_CALLBACK: DiffUtil.ItemCallback<MovieItem>() {
          override fun areItemsTheSame(@NonNull oldItem: MovieItem, @NonNull newItem: MovieItem): Boolean {
              return oldItem.id === newItem.id
          }

          override fun areContentsTheSame(@NonNull oldItem: MovieItem, @NonNull newItem: MovieItem): Boolean {
              return oldItem.equals(newItem)
          }
      }


        override fun equals(obj: Any?): Boolean {
            if (obj === this)
                return true

            val article = obj as MovieItem?
            return article!!.id === this.id
        }




    }

    @Entity(tableName = "movie")
    data class MovieLocalItem(
        val overview: String? = null,

        val originalLanguage: String? = null,

        val title: String? = null,

        val posterPath: String? = null,

        val backdropPath: String? = null,

        val releaseDate: String? = null,

        val voteAverage: Double = 0.0,

        val popularity: Double? = null,

        @PrimaryKey
        val id: Int? = null

    )
}

fun Model.MovieItem.convertToLocal(): Model.MovieLocalItem {
    return Model.MovieLocalItem(
        overview, originalLanguage,
        title, posterPath, backdropPath,
        releaseDate, voteAverage, popularity
    )
}

