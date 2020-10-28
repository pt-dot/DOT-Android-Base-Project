package com.dot.baseandroid.menu.list.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.networks.repositories.ListRepository

class FragmentListViewModel : ViewModel() {

    private val repository = ListRepository(viewModelScope)

    var liveDataList: MutableLiveData<MutableList<PlaceModel>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getList() {
        isLoading.postValue(true)
        repository.getListPlace({
            isLoading.postValue(false)
            liveDataList.postValue(it)
        }, {
            isLoading.postValue(false)
        })
    }

}