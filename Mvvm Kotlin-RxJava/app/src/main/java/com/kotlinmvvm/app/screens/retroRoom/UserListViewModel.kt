package com.kotlinmvvm.app.screens.retroRoom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlinmvvm.app.models.users.UserList
import com.kotlinmvvm.app.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class UserListViewModel @Inject constructor(private val userRepsitry: UserRepositry) : ViewModel() {

    private val disposables = CompositeDisposable()

    // by rx java pattern
    fun getUserListByRxJava(page: String): LiveData<Resource<UserList>> {
        val responseLiveData = MutableLiveData<Resource<UserList>>()
        disposables.add(
            userRepsitry.getUserListByRx(page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(Consumer { responseLiveData.value = Resource.loading(null) })
                .subscribeWith(object : DisposableSingleObserver<UserList>() {
                    override fun onSuccess(value: UserList) {
                        responseLiveData.value = Resource.success(value)
                    }
                    override fun onError(e: Throwable) {
                        val e = e
                        responseLiveData.value = Resource.error(e.message ?: "empty message", null)
                    }
                })
        )
        return responseLiveData
    }

    override fun onCleared() {
        disposables.clear()
    }
}

