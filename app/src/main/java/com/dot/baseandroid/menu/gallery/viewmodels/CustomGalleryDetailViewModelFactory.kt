package com.dot.baseandroid.menu.gallery.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dot.baseandroid.menu.gallery.models.GalleryModel

class CustomGalleryDetailViewModelFactory(private val galleryModel: GalleryModel, val application: Application): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return FragmentGalleryDetailViewModel(galleryModel, application) as T
    }

}