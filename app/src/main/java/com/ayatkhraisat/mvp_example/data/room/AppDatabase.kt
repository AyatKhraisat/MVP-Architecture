package com.ayatkhraisat.mvp_example.data.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ayatkhraisat.mvp_example.models.Model

/**
 * Created by Ayat khraisat  on 4/23/2018.
 *
 */

/*Add all entities (tables) to the database (entities={x,y...etc})
  version is the Database version
  exportSchema is true by default but you can disable it
 for databases when you don't want to keep history of versions
 */
const val DATABASE_NAME = "movie-database"

@Database(entities = [Model.MovieItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {


    abstract fun taskDao(): MovieDao


    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, DATABASE_NAME
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }


}

