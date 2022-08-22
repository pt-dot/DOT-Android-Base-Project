package com.dot.baseandroid.menu.list.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.databinding.ItemPostBinding
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.menu.list.viewmodels.ItemPostViewModel

class ItemPostViewHolder(val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(postModel: PostModel) {
        binding.itemList = ItemPostViewModel(postModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ItemPostViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemPostBinding = ItemPostBinding.inflate(layoutInflater, parent, false)
            return ItemPostViewHolder(binding)
        }
    }
}