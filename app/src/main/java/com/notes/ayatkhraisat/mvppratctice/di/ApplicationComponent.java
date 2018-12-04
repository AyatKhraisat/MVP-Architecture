package com.notes.ayatkhraisat.mvppratctice.di;

import android.app.Application;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface  ApplicationComponent {

     void inject(Application application);

    ActivityComponent getPresenterComponent(ActivityModule activityModule);

}
