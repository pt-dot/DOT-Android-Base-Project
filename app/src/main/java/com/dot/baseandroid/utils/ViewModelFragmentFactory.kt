package com.dot.baseandroid.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.gallery.viewmodels.GalleryDetailViewModel
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.menu.list.viewmodels.ListDetailViewModel

/** REFERENCES
 * https://stackoverflow.com/a/50374088
 */
class ViewModelFragmentFactory(private val any: Any): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == ListDetailViewModel::class.java) {
            return ListDetailViewModel(any as PlaceModel) as T
        } else if (modelClass == GalleryDetailViewModel::class.java) {
            return GalleryDetailViewModel(any as GalleryModel) as T
        }
        return super.create(modelClass)
    }
}