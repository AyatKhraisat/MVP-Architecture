package com.ayatkhraisat.mvp_example.base

interface BaseContract {


    interface BaseView {
        fun toastLong(message: String)


        fun toastShort(message: String)
    }

    interface BaseActionListener<T> {

        fun onAttach (view :T) ;
        fun onDetach();

    }
}
