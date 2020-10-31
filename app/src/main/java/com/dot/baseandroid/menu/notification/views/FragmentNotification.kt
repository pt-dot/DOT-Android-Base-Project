package com.dot.baseandroid.menu.notification.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentNotificationBinding
import com.dot.baseandroid.menu.notification.adapters.NotificationAdapter
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.menu.notification.viewmodels.NotificationViewModel

class FragmentNotification: Fragment() {

    private lateinit var binding: FragmentNotificationBinding
    private val viewModel: NotificationViewModel by viewModels()

    private lateinit var adapter: NotificationAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        binding.lifecycleOwner = this
        binding.notification = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        adapter = NotificationAdapter{
            onItemClicked(it)
        }
        binding.recyclerViewListNotification.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.notificationList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
        viewModel.getLoadingState().observe(viewLifecycleOwner, {

        })
    }

    private fun onItemClicked(notificationModel: NotificationModel) {
        val action = FragmentNotificationDirections.actionToNotificationDetail(notificationModel)
        view?.findNavController()?.navigate(action)
    }

}