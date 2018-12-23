package com.ayatkhraisat.mvp_example.main;

import com.ayatkhraisat.mvp_example.base.BaseContract;

/**
 * Created by Ayat khraisat  on 12/19/18
 * akhraisat@blessedtreeit.com
 * <p>
 * Project Name: PocMvp
 * <p>
 * Blessed Tree IT
 */
public interface MainContract {

    interface MainPresenter extends BaseContract.BasePresenter {


    }


    interface MainView extends BaseContract.BaseView {

        void showTasksFragment();

        void showSecondFragment(int test);

        void closeNavigationDrawer();
    }
}
