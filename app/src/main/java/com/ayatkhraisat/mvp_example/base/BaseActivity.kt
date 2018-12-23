package com.ayatkhraisat.mvp_example.base

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ayatkhraisat.mvp_example.App
import com.ayatkhraisat.mvp_example.di.components.DaggerViewComponent
import com.ayatkhraisat.mvp_example.di.components.ViewComponent
import com.ayatkhraisat.mvp_example.di.modules.ActivityModule
import com.ayatkhraisat.mvp_example.dialogs.SimpleMessageAlertDialog


open class BaseActivity: AppCompatActivity(){


    protected lateinit var viewComponent: ViewComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewComponent = DaggerViewComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as App).applicationComponent).build()
    }


    fun showError(errorMessage: String) {
        val simpleMessageDialogBuilder = SimpleMessageAlertDialog.Builder()
        simpleMessageDialogBuilder
            .setMessage(errorMessage).setTitle("Error")
            .setNegativeButton("Dismiss", DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })

        val simpleMessageAlertDialog = simpleMessageDialogBuilder.build()


        simpleMessageAlertDialog.setCancelable(false)
        simpleMessageAlertDialog.show(supportFragmentManager, "simple_message_dialog")
    }

    fun showMessage(title: String, message: String) {
        val simpleMessageDialogBuilder = SimpleMessageAlertDialog.Builder()
        simpleMessageDialogBuilder
            .setMessage(message).setTitle(title)
            .setNegativeButton("OK", { dialog, which -> dialog.dismiss() })


        val simpleMessageAlertDialog = simpleMessageDialogBuilder.build()


        simpleMessageAlertDialog.setCancelable(false)
        simpleMessageAlertDialog.show(supportFragmentManager, "info_message_dialog")
    }

    fun toastLong(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    fun toastShort(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
