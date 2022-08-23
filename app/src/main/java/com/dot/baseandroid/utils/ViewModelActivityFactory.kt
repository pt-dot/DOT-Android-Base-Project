package com.dot.baseandroid.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.menu.load_more.viewmodels.DetailPostPagingViewModel

class ViewModelActivityFactory(private val application: Application, private val any: Any): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == DetailPostPagingViewModel::class.java) {
            return DetailPostPagingViewModel(application, any as PostModel) as T
        }
        return super.create(modelClass)
    }

}