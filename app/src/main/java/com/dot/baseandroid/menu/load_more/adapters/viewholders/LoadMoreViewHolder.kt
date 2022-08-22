package com.dot.baseandroid.menu.load_more.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.databinding.ItemLoadMoreBinding

class LoadMoreViewHolder(binding: ItemLoadMoreBinding): RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): LoadMoreViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemLoadMoreBinding.inflate(inflater, parent, false)
            return LoadMoreViewHolder(binding)
        }
    }

}