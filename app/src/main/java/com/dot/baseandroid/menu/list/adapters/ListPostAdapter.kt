package com.dot.baseandroid.menu.list.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dot.baseandroid.menu.list.adapters.viewholders.ItemPostViewHolder
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.utils.AdapterCallback

class ListPostAdapter(val onClick:(PostModel) -> Unit): ListAdapter<PostModel, ItemPostViewHolder> (AdapterCallback.DiffListCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPostViewHolder {
        return ItemPostViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemPostViewHolder, position: Int) {
        val postModel = getItem(position)
        holder.bind(postModel)
        holder.itemView.setOnClickListener {
            onClick(postModel)
        }
    }
}