package com.ayatkhraisat.mvp_example.data.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ayatkhraisat.mvp_example.models.Model
import javax.inject.Singleton

/**
 * Created by Ayat khraisat  on 4/23/2018.
 *
 */
const val DATABASE_NAME = "movie-database"

@Singleton
@Database(entities = [Model.MovieItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): MovieDao

    companion object {

        fun getAppDataBase(context: Context): AppDatabase? {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME
            ).build()
        }

    }


}

