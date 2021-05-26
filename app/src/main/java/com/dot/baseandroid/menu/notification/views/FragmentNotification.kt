package com.dot.baseandroid.menu.notification.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentNotificationBinding
import com.dot.baseandroid.menu.notification.adapters.LoadingNotificationAdapter
import com.dot.baseandroid.menu.notification.adapters.NotificationPagingAdapter
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.menu.notification.viewmodels.NotificationViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FragmentNotification: Fragment() {

    private lateinit var binding: FragmentNotificationBinding
    private val viewModel: NotificationViewModel by viewModels()

    private lateinit var notificationPagingAdapter: NotificationPagingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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
            binding.swipeRefreshListNotification.isRefreshing = false
            notificationPagingAdapter.refresh()
        }
    }

    private fun setupRecyclerView() {
        notificationPagingAdapter = NotificationPagingAdapter{
            onItemClicked(it)
        }
        binding.recyclerViewListNotification.adapter = notificationPagingAdapter.withLoadStateFooter(
            footer = LoadingNotificationAdapter()
        )
    }

    private fun observeLiveData() {
        lifecycleScope.launch {
            viewModel.loadPaginationData().collect {
                notificationPagingAdapter.submitData(it)
            }
        }
    }

    private fun onItemClicked(notificationModel: NotificationModel) {
        val action = FragmentNotificationDirections.actionToNotificationDetail(notificationModel)
        view?.findNavController()?.navigate(action)
    }

}