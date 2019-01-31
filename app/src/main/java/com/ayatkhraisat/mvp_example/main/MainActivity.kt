package com.ayatkhraisat.mvp_example.main

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.ayatkhraisat.mvp_example.base.BaseActivity
import com.notes.ayatkhraisat.mvp_example.R

class MainActivity : BaseActivity() {


    private lateinit var drawerLayout: DrawerLayout

    override fun inject() {
        viewComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawer_layout)
        val navController = Navigation.findNavController(this, R.id.top_rated_movies_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(findViewById(R.id.top_rated_movies_fragment))
        return NavigationUI.navigateUp(navController,drawerLayout)
    }

}
