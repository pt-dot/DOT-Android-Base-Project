package com.dot.baseandroid.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupToolbar()
        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragmentContainer).navigateUp()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarMain)
    }

    private fun setupNavigation() {
        binding.bottomNavigationViewMain.itemIconTintList = null
        val navController = Navigation.findNavController(this, R.id.fragmentContainer)
        setupActionBarWithNavController(navController)
        NavigationUI.setupWithNavController(binding.bottomNavigationViewMain, navController)
    }
}
