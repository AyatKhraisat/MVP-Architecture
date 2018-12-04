package com.notes.ayatkhraisat.mvppratctice.di.presenter

import android.preference.PreferenceActivity
import com.bumptech.glide.Glide.init
import com.notes.ayatkhraisat.mvppratctice.base.BaseActivity
import com.notes.ayatkhraisat.mvppratctice.base.BasePresenter
import com.notes.ayatkhraisat.mvppratctice.di.ActivityComponent
import dagger.Provides
import dagger.Subcomponent


@Subcomponent(ActivityComponent<*>::class)
class PresenterModule<P :BasePresenter<>>(val  activity: BaseActivity<P>) {

    internal var https: BaseActivity<*>? = null

    init {
        this.presenter = presenter
    }


    @Provides
    internal fun providesPresenter(): BasePresenter {
        return presenter
    }

}
