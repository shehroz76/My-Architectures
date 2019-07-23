package com.kotlinmvvm.app.screens.retroRoom

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlinmvvm.app.core.store.online.services.ApiService
import com.kotlinmvvm.app.models.users.UserList
import com.kotlinmvvm.app.utils.*
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class UserRepositry @Inject constructor(
    private val context: Context, private val apiService: ApiService
) {


    fun getUserListByRx(page: String): Single<UserList> {
        return apiService.fetchUserByRxJava(page)
    }


}