package com.dot.baseandroid.menu.notification.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.databinding.ItemNotificationBinding
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.menu.notification.viewmodels.ItemNotificationViewModel

class NotificationViewHolder(val binding: ItemNotificationBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(notificationModel: NotificationModel) {
        binding.itemNotification = ItemNotificationViewModel(notificationModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): NotificationViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemNotificationBinding = ItemNotificationBinding.inflate(layoutInflater, parent, false)
            return NotificationViewHolder(binding)
        }
    }

}