package com.notes.ayatkhraisat.mvppratctice.models


import com.google.gson.annotations.SerializedName
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter
import android.widget.ImageView


object Model {


	@BindingAdapter("android:posterImage")
	@JvmStatic
	fun loadPosterImage(view: ImageView, imageUrl: String) {
		Glide.with(view.getContext())
			.load(
				"https://image.tmdb.org/t/p/w500" +
						imageUrl
			)
			.into(view)
	}
	data class MoviesList
		(

		@field:SerializedName("page")
		val page: Int? = null,

		@field:SerializedName("total_pages")
		val totalPages: Int? = null,

		@field:SerializedName("results")
		val results: List<MovieItem?>? = null,

		@field:SerializedName("total_results")
		val totalResults: Int? = null
	)

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

		@field:SerializedName("genre_ids")
		val genreIds: List<Int?>? = null,

		@field:SerializedName("poster_path")
		val posterPath: String? = null,

		@field:SerializedName("backdrop_path")
		val backdropPath: String? = null,

		@field:SerializedName("release_date")
		val releaseDate: String? = null,

		@field:SerializedName("vote_average")
		val voteAverage: Double? = null,

		@field:SerializedName("popularity")
		val popularity: Double? = null,

		@field:SerializedName("id")
		val id: Int? = null,

		@field:SerializedName("adult")
		val adult: Boolean? = null,

		@field:SerializedName("vote_count")
		val voteCount: Int? = null
	) {

	}

}