package com.dot.baseandroid.menu.notification.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.R
import com.dot.baseandroid.menu.notification.adapters.viewholders.NotificationViewHolder
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.utils.AdapterCallback
import com.dot.baseandroid.utils.LoadingState

class NotificationAdapter(val onClick: (NotificationModel) -> Unit): PagedListAdapter<NotificationModel, RecyclerView.ViewHolder>(AdapterCallback.DiffNotificationCallback) {

    companion object {
        const val VIEW_TYPE_ITEM = 1
        const val VIEW_TYPE_LOAD = 2
    }

    private var loadingState = LoadingState.LOADING

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) VIEW_TYPE_ITEM else VIEW_TYPE_LOAD
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == VIEW_TYPE_ITEM) {
            return NotificationViewHolder.from(parent)
        } else {
            val view = inflater.inflate(R.layout.item_load_more, parent, false)
            return LoadMoreViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NotificationViewHolder) {
            val notificationModel: NotificationModel? = getItem(holder.adapterPosition)
            notificationModel?.let {
                holder.bind(notificationModel)
                holder.itemView.setOnClickListener {
                    onClick(notificationModel)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1 else 0
    }

    private fun hasFooter(): Boolean{
        return super.getItemCount() != 0 && loadingState == LoadingState.LOADING
    }

    fun setLoadingState(loadingState: LoadingState) {
        this.loadingState =  loadingState
    }

    class LoadMoreViewHolder(view: View): RecyclerView.ViewHolder(view)

}