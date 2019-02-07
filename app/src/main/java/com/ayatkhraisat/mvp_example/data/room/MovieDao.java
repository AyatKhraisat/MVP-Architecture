package com.ayatkhraisat.mvp_example.data.room;

import androidx.paging.DataSource;
import androidx.room.*;

import com.ayatkhraisat.mvp_example.models.Model;
import io.reactivex.Single;

import java.util.List;

/**
 * Created by Ayat khraisat  on 12/18/18
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: PocMvp
 * <p>
 * Blessed Tree IT
 */
@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie")
    DataSource.Factory<Integer, Model.MovieItem> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<Model.MovieItem> toDoList);



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Model.MovieItem toDoModel);

    @Query("SELECT COUNT() FROM movie")
    int getNumberOfRows();


    @Query("DELETE FROM movie")
    void clearAll();

    @Delete
    void delete(Model.MovieItem toDoModel);

}
