package com.dot.baseandroid.menu.list.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dot.baseandroid.menu.list.models.PlaceModel

class CustomListDetailViewModelFactory(private val placeModel: PlaceModel, val application: Application): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return FragmentListDetailViewModel(placeModel, application) as T
    }

}