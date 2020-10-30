package com.dot.baseandroid.menu.list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dot.baseandroid.menu.list.models.PlaceModel

class FragmentListDetailViewModel(placeModel: PlaceModel) : ViewModel() {

    var name: ObservableField<String> = ObservableField(placeModel.name)
    var description: ObservableField<String> = ObservableField(placeModel.description)
    var imageUrl: ObservableField<String> = ObservableField(placeModel.image)

}