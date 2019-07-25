package com.kotlinmvvm.app.utils


import com.kotlinmvvm.app.utils.Status.*

class ResponseData<out T> constructor(val status: Status, val data: T?, val error: Throwable?) {
    companion object {

        fun loading(): ResponseData<*> {
            return ResponseData(LOADING, null, null)
        }

        fun <T> success(data: T): ResponseData<*> {
            return ResponseData(SUCCESS, data, null)
        }

        fun error(error: Throwable): ResponseData<*> {
            return ResponseData(ERROR, null, error)
        }
    }
}

