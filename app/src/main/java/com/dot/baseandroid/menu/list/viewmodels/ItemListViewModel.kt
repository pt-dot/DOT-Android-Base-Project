package com.dot.baseandroid.menu.list.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.dot.baseandroid.menu.list.models.PlaceModel

class ItemListViewModel(placeModel: PlaceModel): ViewModel() {

    var name: ObservableField<String> = ObservableField(placeModel.name)
    var location: ObservableField<String> = ObservableField(placeModel.location)
    var imageUrl: ObservableField<String> = ObservableField(placeModel.image)
}