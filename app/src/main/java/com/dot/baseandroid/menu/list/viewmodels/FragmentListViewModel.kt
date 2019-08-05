package com.dot.baseandroid.menu.list.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.networks.repositories.ListRepository

class FragmentListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ListRepository(viewModelScope)

    var liveDataList: MutableLiveData<MutableList<PlaceModel>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getList(context: Context) {
        isLoading.postValue(true)
        repository.getListPlace(context, {
            liveDataList.postValue(it)
        }, {
            isLoading.postValue(false)
        })
    }

}