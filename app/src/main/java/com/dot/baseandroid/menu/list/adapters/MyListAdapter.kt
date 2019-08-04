package com.dot.baseandroid.menu.list.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.ItemListBinding
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.menu.list.viewmodels.ItemListViewModel
import com.dot.baseandroid.utils.AdapterCallback

class MyListAdapter(val onClick:(PlaceModel) -> Unit): ListAdapter<PlaceModel, MyListAdapter.ListViewHolder> (AdapterCallback.DiffListCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemListBinding = DataBindingUtil.inflate(inflater, R.layout.item_list, parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val placeModel = getItem(holder.adapterPosition)
        holder.bindData(placeModel)
        holder.itemView.setOnClickListener {
            onClick(placeModel)
        }
    }

    class ListViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(placeModel: PlaceModel) {
            binding.itemList = ItemListViewModel(placeModel)
            binding.executePendingBindings()
        }

    }
}