package com.notes.ayatkhraisat.mvppratctice;


import android.app.Application;
import com.notes.ayatkhraisat.mvppratctice.di.ApplicationComponent;
import com.notes.ayatkhraisat.mvppratctice.di.ApplicationModule;
import com.notes.ayatkhraisat.mvppratctice.di.DaggerApplicationComponent;
import dagger.android.DaggerApplication;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule()).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
