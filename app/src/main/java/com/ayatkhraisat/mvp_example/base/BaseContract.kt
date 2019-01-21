package com.ayatkhraisat.mvp_example.base

interface BaseContract {


    interface BaseView {

    }

    interface BaseActionListener<T> {

        fun onAttach (view :T) ;
        fun onDetach();

    }
}
