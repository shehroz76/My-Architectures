package com.kotlinmvvm.app.screens.retroRoom

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlinmvvm.app.core.store.offline.db.UserDao
import com.kotlinmvvm.app.core.store.online.services.ApiService
import com.kotlinmvvm.app.models.users.DataItem
import com.kotlinmvvm.app.models.users.UserList
import com.kotlinmvvm.app.utils.*
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class UserRepositry @Inject constructor(
    private val context: Context, private val apiService: ApiService,
    private val appExecutors: AppExecutors,
    private val userDao: UserDao
) {

    fun getUserList(page: String): LiveData<Resource<List<DataItem>>> {
        return object : NetworkBoundResource<List<DataItem>, UserList>(appExecutors) {

            override fun saveCallResult(item: UserList) {
                item.data.let {
                    userDao.insertList(it)
                }
            }

            override fun shouldFetch(data: List<DataItem>?): Boolean = true

            override fun loadFromDb(): LiveData<List<DataItem>> = userDao.finAllUsers()

            override fun createCall(): LiveData<ApiResponse<UserList>> = apiService.fetchUser(page)

        }.asLiveData()
    }

}