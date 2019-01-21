package com.ayatkhraisat.mvp_example.base

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ayatkhraisat.mvp_example.App
import com.ayatkhraisat.mvp_example.di.components.DaggerViewComponent
import com.ayatkhraisat.mvp_example.di.components.ViewComponent
import com.ayatkhraisat.mvp_example.di.modules.PresenterModule

import com.ayatkhraisat.mvp_example.di.modules.UiControllerModule
import com.ayatkhraisat.mvp_example.di.modules.ActivityModule
import com.ayatkhraisat.mvp_example.di.modules.RepoModule
import com.ayatkhraisat.mvp_example.dialogs.SimpleMessageAlertDialog


open class BaseActivity: AppCompatActivity(){


    private lateinit var viewComponent: ViewComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewComponent = DaggerViewComponent.builder()
            .presenterModule(PresenterModule())
            .repoModule(RepoModule())
            .uiControllerModule(UiControllerModule(this))
            .applicationComponent((application as App).applicationComponent)
            .build()
    }

    fun getViewComponent ():ViewComponent=viewComponent;

    fun toastLong(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    fun toastShort(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
