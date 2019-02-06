package com.ayatkhraisat.mvp_example.base

import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T : BaseContract.BaseView>() :
    BaseContract.BaseActionListener<T> {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private lateinit var view: T


    override fun onAttach(view: T) {
        this.view = view
    }


    override fun onDetach() {

        compositeDisposable.dispose();
    }


    fun getView() = view
    fun getCompositeDisposable() = compositeDisposable

}
