package com.ayatkhraisat.mvp_example.base

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ayatkhraisat.mvp_example.App
import com.ayatkhraisat.mvp_example.di.components.DaggerViewComponent
import com.ayatkhraisat.mvp_example.di.components.ViewComponent
import com.ayatkhraisat.mvp_example.di.modules.ActivityModule
import io.reactivex.annotations.Nullable


abstract class BaseActivity : AppCompatActivity(),BaseContract.BaseView {

     val viewComponent: ViewComponent by lazy {
        DaggerViewComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as App).applicationComponent).build()
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }


    override fun toastLong(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun toastShort(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected abstract fun inject()

}
