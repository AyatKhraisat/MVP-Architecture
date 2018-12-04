package com.notes.ayatkhraisat.mvppratctice.di;

import com.notes.ayatkhraisat.mvppratctice.base.BaseActivity;
import dagger.Subcomponent;


@Subcomponent(modules = ActivityModule.class)
@ActivityScope
public interface ActivityComponent<A extends BaseActivity> {

      void inject(A activty);

     @Subcomponent(modules = ActivityModule.class)
     @ActivityScope
     interface PresenterComponent<A extends BaseActivity> {

           void inject(A activty);
     }
}
