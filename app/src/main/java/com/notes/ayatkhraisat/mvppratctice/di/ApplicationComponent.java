package com.notes.ayatkhraisat.mvppratctice.di;

import android.app.Application;
import com.notes.ayatkhraisat.mvppratctice.di.presenter.PresenterModule;
import com.notes.ayatkhraisat.mvppratctice.di.presenter.RepoModule;
import com.notes.ayatkhraisat.mvppratctice.top_rated.TopRatedMoviesActivity;
import dagger.Component;
import dagger.android.DaggerApplication;

import javax.inject.Singleton;

@Singleton
@Component(modules = {RepoModule.class, PresenterModule.class})
public interface ApplicationComponent {

    void inject(TopRatedMoviesActivity topRatedMoviesActivity);





}
