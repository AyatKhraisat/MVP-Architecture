package com.ayatkhraisat.mvp_example.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayatkhraisat.mvp_example.base.BaseActivity
import com.notes.ayatkhraisat.mvp_example.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
