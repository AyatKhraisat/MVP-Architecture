package com.ayatkhraisat.mvp_example.di.modules

import androidx.annotation.NonNull
import com.ayatkhraisat.mvp_example.network.MoviesService
import okhttp3.OkHttpClient
import javax.inject.Singleton
import dagger.Provides
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import dagger.Module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 *Created by Ayat Khriasat on 14,December,2018 at 7:57 PM
 *Email: ayatzkhraisat@gmail.com
 *Project: MvpPratctice
 **/
@Module
@Singleton
class NetworkModule(val baseUrl: String) {


    @Provides
    @Singleton
    @NonNull
    internal fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(5, TimeUnit.MINUTES) // connect timeout
            .writeTimeout(5, TimeUnit.MINUTES) // write timeout
            .readTimeout(5, TimeUnit.MINUTES) // read timeout

        return builder.build()
    }


    @Provides
    @Singleton
    @NonNull
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @NonNull
    internal fun provideMovieService(retrofit: Retrofit): MoviesService {
        return retrofit.create<MoviesService>(MoviesService::class.java!!)

    }

}