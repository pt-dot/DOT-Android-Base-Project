package com.dot.baseandroid.menu.notification.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.ItemNotificationBinding
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.utils.AdapterCallback

class NotificationAdapter: PagedListAdapter<NotificationModel, RecyclerView.ViewHolder>(AdapterCallback.DiffNotificationCallback) {

    companion object {
        const val VIEW_TYPE_ITEM = 1
        const val VIEW_TYPE_LOAD = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) VIEW_TYPE_ITEM else VIEW_TYPE_LOAD
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == VIEW_TYPE_ITEM) {
            val binding: ItemNotificationBinding = DataBindingUtil.inflate(inflater, R.layout.item_notification, parent, false)
            return NotificationViewHolder(binding)
        } else {
            val view = inflater.inflate(R.layout.item_load_more, parent, false)
            return LoadMoreViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class NotificationViewHolder(val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(notificationModel: NotificationModel) {

        }
    }

    class LoadMoreViewHolder(view: View): RecyclerView.ViewHolder(view)

}