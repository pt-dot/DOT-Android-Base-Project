package com.dot.baseandroid.menu.list.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.dot.baseandroid.menu.list.models.PlaceModel

class FragmentListDetailViewModel(placeModel: PlaceModel, application: Application) : AndroidViewModel(application) {

    var name: ObservableField<String> = ObservableField(placeModel.name)
    var description: ObservableField<String> = ObservableField(placeModel.description)
    var imageUrl: ObservableField<String> = ObservableField(placeModel.image)

}