package com.dot.baseandroid.networks

import android.content.Context
import com.dot.baseandroid.utils.logDebug
import com.dot.baseandroid.utils.logError
import com.dot.baseandroid.utils.showToast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response

class Network(private val coroutineScope: CoroutineScope) {

    fun <T> request(context: Context, response: suspend() -> Response<T>, onSuccess:(T?) -> Unit, onFinally:(Boolean) -> Unit) {
        coroutineScope.launch {
            try {
                val result = response()
               if (result.isSuccessful) {
                   logDebug("Network # isSuccessful")
                   logDebug("Network # url API : ${result.raw().request().url()}")
                   onSuccess(result.body())
               } else {
                   logError("Network # UnSuccessFul")
                   logError("Network # url API : ${result.raw().request().url()}")
                   logError("Network # code : ${result.code()}")
                   logError("Network # body : ${result.errorBody()?.string()}")
                   context.showToast("UnSuccessFul # code : ${result.code()}")
               }
            } catch (throwable: Throwable) {
                logError("Network # Throwable")
                context.showToast("Throwable ${throwable.message})}")
                throwable.printStackTrace()
            } finally {
                logDebug("Network # finally")
                onFinally(true)
            }
        }
    }

}