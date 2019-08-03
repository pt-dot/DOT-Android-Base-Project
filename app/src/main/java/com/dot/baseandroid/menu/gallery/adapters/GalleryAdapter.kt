package com.dot.baseandroid.menu.gallery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.ItemGalleryBinding
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.gallery.viewmodels.ItemGalleryViewModel

class GalleryAdapter(val onClick:(GalleryModel) -> Unit): ListAdapter<GalleryModel, GalleryAdapter.GalleryViewHolder> (DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemGalleryBinding = DataBindingUtil.inflate(inflater, R.layout.item_gallery, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val galleryModel = getItem(holder.adapterPosition)
        holder.bindData(galleryModel)
        holder.itemView.setOnClickListener {
            onClick(galleryModel)
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<GalleryModel>() {
        override fun areContentsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
            return oldItem.caption == newItem.caption
        }
    }

    class GalleryViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var viewModel: ItemGalleryViewModel
        fun bindData(galleryModel: GalleryModel) {
            viewModel = ItemGalleryViewModel(galleryModel)
            binding.itemGallery = viewModel
            binding.executePendingBindings()
        }

    }

}