package com.dot.baseandroid.utils

import androidx.recyclerview.widget.DiffUtil
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.list.models.PostModel

class AdapterCallback {

    companion object {

        /**
         * diff callback adapter list
         */
        val DiffListCallback = object : DiffUtil.ItemCallback<PostModel>() {
            override fun areContentsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: PostModel, newItem: PostModel): Boolean {
                return oldItem.id == newItem.id
            }
        }

        /**
         * diff callback adapter gallery
         */
        val DiffGalleryCallback = object : DiffUtil.ItemCallback<GalleryModel>() {
            override fun areContentsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: GalleryModel, newItem: GalleryModel): Boolean {
                return oldItem.id == newItem.id
            }
        }

    }



}