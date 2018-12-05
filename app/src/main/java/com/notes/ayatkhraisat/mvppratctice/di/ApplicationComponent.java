package com.notes.ayatkhraisat.mvppratctice.di;

import android.app.Application;
import com.notes.ayatkhraisat.mvppratctice.di.presenter.PresenterCompontent;
import com.notes.ayatkhraisat.mvppratctice.di.presenter.PresenterModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface  ApplicationComponent {

     void inject(Application application);

    PresenterCompontent getPresenterComponent(PresenterModule presenterModule);

}
