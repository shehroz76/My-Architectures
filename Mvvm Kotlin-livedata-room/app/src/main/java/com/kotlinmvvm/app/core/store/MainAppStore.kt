package com.kotlinmvvm.app.core.store

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.kotlinmvvm.app.core.store.offline.OfflineStore
import com.kotlinmvvm.app.core.store.online.OnlineStore
import com.kotlinmvvm.app.models.UserProfile
import javax.inject.Inject


class MainAppStore
@Inject constructor(
    val onlineStore: OnlineStore,
    val offlineStore: OfflineStore
) {


    fun cacheUser(@NonNull userProfile: UserProfile) {
        offlineStore.cacheUser(userProfile)
    }

    @Nullable
    fun getCachedUser(): UserProfile {
        return offlineStore.getCachedUser()
    }

    fun setFirstTimeLaunch() {
        offlineStore.setFirstTimeLaunch()
    }

    fun isFirstTimeLaunch(): Boolean {
        return offlineStore.isFirstTimeLaunch()
    }

    fun isLoggedIn(): Boolean {
        return offlineStore.isLoggedIn()
    }

    fun setLoggedIn(loggedIn: Boolean) {
        offlineStore.setLoggedIn(loggedIn)
    }

}