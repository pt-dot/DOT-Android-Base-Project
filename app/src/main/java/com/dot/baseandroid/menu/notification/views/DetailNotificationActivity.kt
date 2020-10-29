package com.dot.baseandroid.menu.notification.views

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.navArgs
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.ActivityNotificationDetailBinding
import com.dot.baseandroid.menu.notification.viewmodels.DetailNotificationViewModel
import com.dot.baseandroid.utils.ViewModelActivityFactory

class DetailNotificationActivity: AppCompatActivity(){

    private val args: DetailNotificationActivityArgs by navArgs()
    private lateinit var binding: ActivityNotificationDetailBinding
    private val viewModel: DetailNotificationViewModel by viewModels { ViewModelActivityFactory(application, args.dataDetailNotification) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_detail)
        binding.lifecycleOwner = this
        binding.notification = viewModel

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