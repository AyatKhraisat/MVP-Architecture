package com.ayatkhraisat.mvp_example.data.room

import androidx.*
import androidx.paging.DataSource
import androidx.room.*

import com.ayatkhraisat.mvp_example.models.Model
import io.reactivex.Single

/**
 * Created by Ayat khraisat  on 12/18/18
 * akhraisat@blessedtreeit.com
 *
 *
 * Project Name: PocMvp
 *
 *
 * Blessed Tree IT
 */

@Dao
interface MovieDao {

    @get:Query("SELECT * FROM movie")
    val all: DataSource.Factory<Int, Model.MovieItem>

    @get:Query("SELECT COUNT() FROM movie")
    val numberOfRows: Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(moviesList: ArrayList<Model.MovieItem?>?)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(movieModel: Model.MovieItem)


    @Query("DELETE FROM movie")
    fun clearAll()

    @Delete
    fun delete(movieModel: Model.MovieItem)

}