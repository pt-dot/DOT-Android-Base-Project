package com.dot.baseandroid.menu.notification.views

import android.os.Bundle
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
    }

}