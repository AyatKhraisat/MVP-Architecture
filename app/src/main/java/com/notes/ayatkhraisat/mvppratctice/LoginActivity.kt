package com.notes.ayatkhraisat.mvppratctice

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.notes.ayatkhraisat.mvppratctice.databinding.ActivityLoginBinding
import com.notes.ayatkhraisat.mvppratctice.model.User

class LoginActivity : AppCompatActivity() {

    lateinit var  loginBinding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        loginBinding.user= User();
    }
}
