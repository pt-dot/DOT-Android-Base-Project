package com.dot.baseandroid.menu.list.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.networks.repositories.PostRepository

class ListPostViewModel : ViewModel() {

    private val repository = PostRepository(viewModelScope)

    var liveDataList: MutableLiveData<MutableList<PostModel>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getPosts() {
        isLoading.postValue(true)
        repository.getPosts({
            isLoading.postValue(false)
            liveDataList.postValue(it)
        }, {
            isLoading.postValue(false)
        })
    }

}