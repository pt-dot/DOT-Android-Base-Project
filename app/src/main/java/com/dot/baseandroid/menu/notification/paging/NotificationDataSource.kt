package com.dot.baseandroid.menu.notification.paging

import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.dot.baseandroid.data.Constants
import com.dot.baseandroid.menu.notification.models.NotificationModel
import com.dot.baseandroid.utils.LoadingState
import com.dot.baseandroid.utils.logDebug

class NotificationDataSource: PageKeyedDataSource<Int, NotificationModel>() {

    var state: MutableLiveData<LoadingState> = MutableLiveData()
    var listNotification: MutableList<NotificationModel> = mutableListOf()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, NotificationModel>) {
        logDebug("NotificationDataSource # loadInitial ${params.requestedLoadSize}")
        updateState(LoadingState.LOADING)
        listNotification.clear()
        for (i:Int in 1..20) {
            listNotification.add(NotificationModel(i, "Notification # $i"))
        }
        updateState(LoadingState.DONE)
        callback.onResult(listNotification, 0, 20)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, NotificationModel>) {
        logDebug("NotificationDataSource # loadAfter ${params.key}/${params.requestedLoadSize}")
        updateState(LoadingState.LOADING)
        listNotification.clear()
        for (i:Int in 1..20) {
            listNotification.add(NotificationModel(i, "Notification # $i"))
        }
        SystemClock.sleep(Constants.DUMMY_LOAD_MORE_TIME)
        updateState(LoadingState.DONE)
        callback.onResult(listNotification, params.key+20)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, NotificationModel>) {

    }

    private fun updateState(state: LoadingState){
        this.state.postValue(state)
    }
}