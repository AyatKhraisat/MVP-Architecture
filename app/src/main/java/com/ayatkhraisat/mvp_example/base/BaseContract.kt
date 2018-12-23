package com.ayatkhraisat.mvp_example.base

interface BaseContract {


    interface BaseView {

        fun showError(errorMessage: String)

        fun showMessage(title: String, message: String)

        fun toastLong(message: String)


        fun toastShort(message: String)


    }


    interface BasePresenter {
         fun detachView()
    }
}
