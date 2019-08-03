package com.dot.baseandroid.menu.gallery.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dot.baseandroid.menu.gallery.models.GalleryModel

class ItemGalleryViewModel(galleryModel: GalleryModel): ViewModel() {

    var thumbnail: ObservableField<String> = ObservableField(galleryModel.thumbnail)

}