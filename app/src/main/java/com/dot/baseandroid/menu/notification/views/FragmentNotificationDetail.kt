package com.dot.baseandroid.menu.notification.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentNotificationBinding

class FragmentNotificationDetail: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentNotificationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification_detail, container, false)
        return binding.root
    }

}