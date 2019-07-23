package com.kotlinmvvm.app.screens.retroRoom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlinmvvm.app.models.users.UserList
import com.kotlinmvvm.app.utils.ApiResponse
import com.kotlinmvvm.app.utils.Resource
import com.kotlinmvvm.app.utils.ResponseData
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class UserListViewModel @Inject constructor(private val userRepsitry: UserRepositry) : ViewModel() {

    // by live-data adapter pattern
    fun getUserListByLiveData(page: String): LiveData<Resource<UserList>> {
        return userRepsitry.getUserList(page);
    }

}

