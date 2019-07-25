package com.kotlinmvvm.app.core.store.online.services


import androidx.lifecycle.LiveData
import com.kotlinmvvm.app.models.users.UserList
import com.kotlinmvvm.app.utils.ApiResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.POST


interface ApiService {

    @GET("api/users")
    fun fetchUser(@Query("page") page: String): LiveData<ApiResponse<UserList>>

    @GET("api/users")
    fun fetchUserByCall(@Query("page") page: String): Call<UserList>

    @GET("api/users")
    fun fetchUserByRxJava(@Query("page") page: String): Single<UserList>

}
