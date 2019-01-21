package com.ayatkhraisat.mvp_example.base

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.ayatkhraisat.mvp_example.App
import com.ayatkhraisat.mvp_example.di.components.DaggerViewComponent
import com.ayatkhraisat.mvp_example.di.components.ViewComponent
import com.ayatkhraisat.mvp_example.di.modules.PresenterModule
import com.ayatkhraisat.mvp_example.di.modules.RepoModule
import com.ayatkhraisat.mvp_example.di.modules.UiControllerModule


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
}
