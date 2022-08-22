package com.dot.baseandroid.menu.load_more.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.dot.baseandroid.menu.list.models.PostModel

class DetailPostPagingViewModel(application: Application, postModel: PostModel) : AndroidViewModel(application) {

    var message: ObservableField<String> = ObservableField(postModel.title)

}