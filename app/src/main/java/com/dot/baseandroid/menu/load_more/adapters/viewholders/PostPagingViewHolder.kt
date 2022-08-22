package com.dot.baseandroid.menu.load_more.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.databinding.ItemPostPagingBinding
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.menu.load_more.viewmodels.ItemPostPagingViewModel

class PostPagingViewHolder(val binding: ItemPostPagingBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(postModel: PostModel) {
        binding.post = ItemPostPagingViewModel(postModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): PostPagingViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemPostPagingBinding.inflate(layoutInflater, parent, false)
            return PostPagingViewHolder(binding)
        }
    }

}