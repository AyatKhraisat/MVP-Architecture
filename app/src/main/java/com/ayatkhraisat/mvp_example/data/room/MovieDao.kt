package com.ayatkhraisat.mvp_example.data.room

import androidx.room.*
import com.ayatkhraisat.mvp_example.models.Model
import io.reactivex.Single

/**
 * Created by Ayat khraisat  on 2/12/19
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVP_Architecture
 * <p>
 */
@Dao
interface MovieDao {

    @get:Query("SELECT * FROM movie")
    val all: Single<List<Model.MovieLocalItem>>

    @get:Query("SELECT COUNT() FROM movie")
    val numberOfRows: Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(toDoList: List<Model.MovieLocalItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(toDoModel: Model.MovieLocalItem)

    @Query("DELETE FROM movie")
    fun clearAll()

    @Delete
    fun delete(toDoModel: Model.MovieLocalItem)

}
