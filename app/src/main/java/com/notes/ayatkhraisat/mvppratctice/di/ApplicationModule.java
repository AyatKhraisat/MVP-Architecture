package com.notes.ayatkhraisat.mvppratctice.di;

import android.app.Application;
import android.content.Context;
import com.notes.ayatkhraisat.mvppratctice.App;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ApplicationModule {

    private Application application;


    ApplicationModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Context bindContext(Application application) {
        return application;
    }
}
