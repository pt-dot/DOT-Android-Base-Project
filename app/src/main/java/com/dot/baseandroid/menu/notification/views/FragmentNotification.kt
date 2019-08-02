package com.dot.baseandroid.menu.notification.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentNotificationBinding
import com.dot.baseandroid.menu.notification.viewmodels.FragmentNotificationViewModel

class FragmentNotification: Fragment() {

    private lateinit var binding: FragmentNotificationBinding
    private lateinit var viewModel: FragmentNotificationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = FragmentNotificationViewModel(activity?.application!!)
        binding.notification = viewModel
    }

}