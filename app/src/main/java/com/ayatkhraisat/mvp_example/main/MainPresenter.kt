package com.ayatkhraisat.mvp_example.main

import javax.inject.Inject

/**
 * Created by Ayat khraisat  on 12/23/18
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: MVPPractice
 * <p>
 * Blessed Tree IT
 */

public class MainPresenter @Inject constructor(private val mainView: MainContract.MainView) : MainContract.MainPresenter {


    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    init {
        mainView.showTasksFragment()

    }

//    fun detachView() {
//
//
//    }
//
//    fun tasksMenuClicked() {
//
//        mainView!!.showTasksFragment()
//
//    }
//
//    fun secondClicked(test: Int) {
//        mainView!!.showSecondFragment(test)
//    }
}
