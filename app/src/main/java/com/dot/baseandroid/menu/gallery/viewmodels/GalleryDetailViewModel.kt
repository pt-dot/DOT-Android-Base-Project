package com.dot.baseandroid.menu.gallery.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dot.baseandroid.menu.gallery.models.GalleryModel

class GalleryDetailViewModel(galleryModel: GalleryModel) : ViewModel() {

    var imageUrl: ObservableField<String> = ObservableField(galleryModel.image)
    var caption: ObservableField<String> = ObservableField(galleryModel.caption)

}