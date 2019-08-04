package com.dot.baseandroid.utils

import androidx.recyclerview.widget.DiffUtil
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.list.models.PlaceModel

class AdapterCallback {

    companion object {

        /**
         * diff callback adapter list
         */
        val DiffListCallback = object : DiffUtil.ItemCallback<PlaceModel>() {
            override fun areContentsTheSame(oldItem: PlaceModel, newItem: PlaceModel): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: PlaceModel, newItem: PlaceModel): Boolean {
                return oldItem.name == newItem.name
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
                return oldItem.caption == newItem.caption
            }
        }

    }



}