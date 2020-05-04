package com.dot.baseandroid.menu.list.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dot.baseandroid.menu.list.adapters.viewholders.ListViewHolder
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.utils.AdapterCallback

class MyListAdapter(val onClick:(PlaceModel) -> Unit): ListAdapter<PlaceModel, ListViewHolder> (AdapterCallback.DiffListCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val placeModel = getItem(holder.adapterPosition)
        holder.bind(placeModel)
        holder.itemView.setOnClickListener {
            onClick(placeModel)
        }
    }
}