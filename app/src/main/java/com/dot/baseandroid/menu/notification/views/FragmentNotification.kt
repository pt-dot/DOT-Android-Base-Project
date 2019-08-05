package com.dot.baseandroid.menu.notification.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentNotificationBinding
import com.dot.baseandroid.menu.notification.adapters.NotificationAdapter
import com.dot.baseandroid.menu.notification.viewmodels.FragmentNotificationViewModel

class FragmentNotification: Fragment() {

    private lateinit var binding: FragmentNotificationBinding
    private lateinit var viewModel: FragmentNotificationViewModel

    private lateinit var adapter: NotificationAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = FragmentNotificationViewModel(activity?.application!!)
        binding.notification = viewModel

        setupSwipeRefresh()
        setupRecyclerView()
        observeLiveData()
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshListNotification.setOnRefreshListener {
            viewModel.refreshListNotification()
        }
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerViewListNotification.layoutManager = layoutManager
        adapter = NotificationAdapter()
        binding.recyclerViewListNotification.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.notificationList.observe(this, Observer {
            adapter.submitList(it)
        })
        viewModel.getLoadingState().observe(this, Observer {

        })
    }

}