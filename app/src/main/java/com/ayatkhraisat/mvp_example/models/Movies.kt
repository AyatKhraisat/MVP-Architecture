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
        val page: Int,

        @field:SerializedName("total_pages")
        val totalPages: Int,

        @field:SerializedName("results")
        val results: ArrayList<MovieItem?>,

        @field:SerializedName("total_results")
        val totalResults: Int
    )

    data class MovieItem(
        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("original_language")
        val originalLanguage: String,

        @field:SerializedName("original_title")
        val originalTitle: String,

        @field:SerializedName("video")
        val video: Boolean,

        @field:SerializedName("title")
        val title: String,

        @field:SerializedName("genre_ids")
        val genreIds: List<Int?>,

        @field:SerializedName("poster_path")
        val posterPath: String,

        @field:SerializedName("backdrop_path")
        val backdropPath: String,

        @field:SerializedName("release_date")
        val releaseDate: String,

        @field:SerializedName("vote_average")
        val voteAverage: Double = 0.0,

        @field:SerializedName("popularity")
        val popularity: Double,

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("adult")
        val adult: Boolean,

        @field:SerializedName("vote_count")
        val voteCount: Int
    ) {


        object DIFF_CALLBACK : DiffUtil.ItemCallback<MovieItem>() {
            override fun areItemsTheSame(@NonNull oldItem: MovieItem, @NonNull newItem: MovieItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(@NonNull oldItem: MovieItem, @NonNull newItem: MovieItem): Boolean {
                return oldItem.equals(newItem)
            }
        }

        override fun equals(obj: Any?): Boolean {
            if (obj === this)
                return true

            val article = obj as MovieItem?
            return article!!.id == this.id
        }

        override fun hashCode(): Int {
            var result = overview.hashCode()
            result = 31 * result + originalLanguage.hashCode()
            result = 31 * result + originalTitle.hashCode()
            result = 31 * result + video.hashCode()
            result = 31 * result + title.hashCode()
            result = 31 * result + genreIds.hashCode()
            result = 31 * result + posterPath.hashCode()
            result = 31 * result + backdropPath.hashCode()
            result = 31 * result + releaseDate.hashCode()
            result = 31 * result + voteAverage.hashCode()
            result = 31 * result + popularity.hashCode()
            result = 31 * result + id
            result = 31 * result + adult.hashCode()
            result = 31 * result + voteCount
            return result
        }


    }

    @Entity(tableName = "movie")
    data class MovieLocalItem(
        val overview: String,

        val originalLanguage: String,

        val title: String,

        val posterPath: String,

        val backdropPath: String,

        val releaseDate: String,

        val voteAverage: Double = 0.0,

        val popularity: Double,

        @PrimaryKey
        val id: Int

    )
}

fun Model.MovieItem.convertToLocal(): Model.MovieLocalItem {
    return Model.MovieLocalItem(
        overview, originalLanguage,
        title, posterPath, backdropPath,
        releaseDate, voteAverage, popularity
        , id
    )
}

