package com.dot.baseandroid.menu.gallery.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dot.baseandroid.menu.gallery.adapters.viewholders.GalleryViewHolder
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.utils.AdapterCallback

class GalleryAdapter(val onClick:(GalleryModel) -> Unit): ListAdapter<GalleryModel, GalleryViewHolder> (AdapterCallback.DiffGalleryCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val galleryModel = getItem(holder.adapterPosition)
        holder.bind(galleryModel)
        holder.itemView.setOnClickListener {
            onClick(galleryModel)
        }
    }

}