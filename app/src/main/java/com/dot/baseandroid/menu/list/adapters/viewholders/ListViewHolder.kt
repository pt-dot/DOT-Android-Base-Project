package com.dot.baseandroid.menu.list.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.databinding.ItemListBinding
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.menu.list.viewmodels.ItemListViewModel

class ListViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(placeModel: PlaceModel) {
        binding.itemList = ItemListViewModel(placeModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemListBinding = ItemListBinding.inflate(layoutInflater, parent, false)
            return ListViewHolder(binding)
        }
    }
}