package com.ayatkhraisat.mvp_example.di.modules

import android.content.Context
import com.ayatkhraisat.mvp_example.base.BaseActivity
import com.ayatkhraisat.mvp_example.data.DataSourceFactory
import com.ayatkhraisat.mvp_example.data.room.AppDatabase
import com.ayatkhraisat.mvp_example.data.room.MovieDao
import com.ayatkhraisat.mvp_example.di.qualifires.ActivityContext
import com.ayatkhraisat.mvp_example.di.scopes.ViewScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Ayat khraisat  on 12/23/18
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVPPractice
 * <p>
 * Blessed Tree IT
 */
@Module
class ActivityModule(val context: Context) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return context
    }


    @Provides
    @ViewScope
    fun provideTasksDao(): MovieDao {
        return AppDatabase.getAppDataBase(context)!!.taskDao()

    }


    @Provides
    @ViewScope
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }


    @Provides
    @ViewScope
    fun provideBaseActivity(@ActivityContext context: Context): BaseActivity {
        return context as BaseActivity
    }




}
