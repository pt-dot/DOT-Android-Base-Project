package com.dot.baseandroid.menu.load_more.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dot.baseandroid.menu.list.models.PostModel

class ItemPostPagingViewModel(postModel: PostModel): ViewModel() {

    var message: ObservableField<String> = ObservableField("${postModel.id}. ${postModel.title}")

}