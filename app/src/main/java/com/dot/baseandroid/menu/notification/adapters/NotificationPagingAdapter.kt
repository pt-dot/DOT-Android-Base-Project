package com.dot.baseandroid.menu.notification.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.dot.baseandroid.menu.notification.adapters.viewholders.NotificationViewHolder
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.utils.AdapterCallback

class NotificationPagingAdapter(val onClick: (NotificationModel) -> Unit): PagingDataAdapter<NotificationModel, NotificationViewHolder>
    (AdapterCallback.DiffNotificationCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notificationModel: NotificationModel? = getItem(position)
        notificationModel?.let {
            holder.bind(notificationModel)
            holder.itemView.setOnClickListener {
                onClick(notificationModel)
            }
        }

    }

}