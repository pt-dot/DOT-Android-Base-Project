package com.dot.baseandroid.menu.gallery.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.dot.baseandroid.menu.gallery.models.GalleryModel

class FragmentGalleryDetailViewModel(galleryModel: GalleryModel, application: Application) : AndroidViewModel(application) {

    var imageUrl: ObservableField<String> = ObservableField(galleryModel.image)
    var caption: ObservableField<String> = ObservableField(galleryModel.caption)

}