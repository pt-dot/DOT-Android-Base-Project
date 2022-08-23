package com.dot.baseandroid.menu.list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dot.baseandroid.menu.list.models.PostModel

class ListPostDetailViewModel(postModel: PostModel) : ViewModel() {

    var title: ObservableField<String> = ObservableField(postModel.title)
    var body: ObservableField<String> = ObservableField(postModel.body)

}