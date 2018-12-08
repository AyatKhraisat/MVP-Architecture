package com.notes.ayatkhraisat.mvppratctice;


import android.app.Application;
import com.notes.ayatkhraisat.mvppratctice.di.ApplicationComponent;
import com.notes.ayatkhraisat.mvppratctice.di.DaggerApplicationComponent;
import com.notes.ayatkhraisat.mvppratctice.di.presenter.PresenterModule;
import com.notes.ayatkhraisat.mvppratctice.di.presenter.RepoModule;
import dagger.android.DaggerApplication;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
         applicationComponent = DaggerApplicationComponent.builder().
                repoModule(new RepoModule()).
                presenterModule(new PresenterModule()).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
