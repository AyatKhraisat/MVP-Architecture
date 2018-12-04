package com.notes.ayatkhraisat.mvppratctice.di.presenter


import com.notes.ayatkhraisat.mvppratctice.base.BasePresenter
import dagger.Subcomponent

@Subcomponent(modules =Array{PresenterModule::class})
interface PresenterCompontent {

    fun inject(basePresenter: BasePresenter)
}
