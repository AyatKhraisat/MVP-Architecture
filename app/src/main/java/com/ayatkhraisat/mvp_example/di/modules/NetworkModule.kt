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
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()


    @Provides
    @Singleton
    @NonNull
    fun provideRetrofit( okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build();

    @Provides
    @Singleton
    @NonNull
    fun provideMovieService(retrofit: Retrofit) = retrofit.create(MoviesService::class.java)
}