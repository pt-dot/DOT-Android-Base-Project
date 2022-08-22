package com.dot.baseandroid.menu.load_more.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.menu.load_more.adapters.viewholders.PostPagingViewHolder
import com.dot.baseandroid.utils.AdapterCallback

class PostPagingAdapter(val onClick: (PostModel) -> Unit): PagingDataAdapter<PostModel, PostPagingViewHolder>
    (AdapterCallback.DiffListCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostPagingViewHolder {
        return PostPagingViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PostPagingViewHolder, position: Int) {
        val notificationModel: PostModel? = getItem(position)
        notificationModel?.let {
            holder.bind(notificationModel)
            holder.itemView.setOnClickListener {
                onClick(notificationModel)
            }
        }

    }

}