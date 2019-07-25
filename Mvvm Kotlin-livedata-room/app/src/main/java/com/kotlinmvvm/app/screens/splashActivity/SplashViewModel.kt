package com.kotlinmvvm.app.screens.splashActivity

import androidx.lifecycle.ViewModel
import com.kotlinmvvm.app.core.store.MainAppStore
import javax.inject.Inject

class SplashViewModel @Inject constructor(val store: MainAppStore) : ViewModel() {

    fun isFirstTimeLaunch(): Boolean {
        return store.isFirstTimeLaunch()
    }

    fun isLoggedIn(): Boolean {
        return store.isLoggedIn()
    }
}

