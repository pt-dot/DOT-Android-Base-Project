package com.dot.baseandroid.menu.gallery.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.databinding.ItemGalleryBinding
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.gallery.viewmodels.ItemGalleryViewModel

class GalleryViewHolder(val binding: ItemGalleryBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(galleryModel: GalleryModel) {
        binding.itemGallery = ItemGalleryViewModel(galleryModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): GalleryViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemGalleryBinding = ItemGalleryBinding.inflate(layoutInflater, parent, false)
            return GalleryViewHolder(binding)
        }
    }

}