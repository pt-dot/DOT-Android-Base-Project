package com.dot.baseandroid.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.gallery.viewmodels.FragmentGalleryDetailViewModel
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.menu.list.viewmodels.FragmentListDetailViewModel

/** REFERENCES
 * https://stackoverflow.com/a/50374088
 */
class ViewModelFragmentFactory(private val any: Any): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == FragmentListDetailViewModel::class.java) {
            return FragmentListDetailViewModel(any as PlaceModel) as T
        } else if (modelClass == FragmentGalleryDetailViewModel::class.java) {
            return FragmentGalleryDetailViewModel(any as GalleryModel) as T
        }
        return super.create(modelClass)
    }
}