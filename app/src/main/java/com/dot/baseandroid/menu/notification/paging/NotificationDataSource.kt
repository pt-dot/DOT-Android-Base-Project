package com.dot.baseandroid.menu.notification.paging

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.dot.baseandroid.data.Constants
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.utils.LoadingState

class NotificationDataSource: PageKeyedDataSource<Int, NotificationModel>() {

    var state: MutableLiveData<LoadingState> = MutableLiveData()
    var listNotification: MutableList<NotificationModel> = mutableListOf()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, NotificationModel>) {
        updateState(LoadingState.LOADING)
        Handler().postDelayed({
            listNotification.clear()
            for (i:Int in 0..20) {
                listNotification.add(NotificationModel(i, "Notification # $i"))
            }
            updateState(LoadingState.DONE)
            callback.onResult(listNotification, null, 20)
        }, Constants.DUMMY_LOAD_MORE_TIME)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, NotificationModel>) {
        updateState(LoadingState.LOADING)
        Handler().postDelayed({
            listNotification.clear()
            for (i:Int in 0..20) {
                listNotification.add(NotificationModel(i, "Notification # $i ${params.key}"))
            }
            updateState(LoadingState.DONE)
            callback.onResult(listNotification, params.key+20)
        }, Constants.DUMMY_LOAD_MORE_TIME)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, NotificationModel>) {

    }

    private fun updateState(state: LoadingState){
        this.state.postValue(state)
    }
}