package com.dot.baseandroid.menu.gallery.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.networks.repositories.GalleryRepository

class FragmentGalleryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GalleryRepository(viewModelScope)

    var liveDataListGallery: MutableLiveData<MutableList<GalleryModel>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getListGallery(context: Context) {
        isLoading.postValue(true)
        repository.getListGallery(context, {
            liveDataListGallery.postValue(it)
        }, {
            isLoading.postValue(false)
        })
    }

}