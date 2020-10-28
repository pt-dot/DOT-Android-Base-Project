package com.dot.baseandroid.menu.notification.views

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.ActivityNotificationDetailBinding

class DetailNotificationActivity: AppCompatActivity(){

    companion object {
        const val EXTRA_DATA_NOTIFICATION = "extra_data_notification"
    }

    private lateinit var binding: ActivityNotificationDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_detail)
        binding.lifecycleOwner = this

        setupToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.tbNotificationDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.detail)
    }

}