package com.kotlinmvvm.app.core.store.offline

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.kotlinmvvm.app.core.managers.PrefManagers
import com.kotlinmvvm.app.models.UserProfile
import javax.inject.Inject

class OfflineStore @Inject constructor(val prefManager: PrefManagers) {

    fun cacheUser(@NonNull userProfile: UserProfile) {
        prefManager.cacheUser(userProfile)
    }

    @Nullable
    fun getCachedUser(): UserProfile {
        return prefManager.getCachedUser()
    }

    fun setFirstTimeLaunch() {
        prefManager.setFirstTimeLaunch(false)
    }

    fun isFirstTimeLaunch(): Boolean {
        return prefManager.isFirstTimeLaunch()
    }

    fun isLoggedIn(): Boolean {
        return prefManager.isLoggedIn()
    }

    fun setLoggedIn(loggedIn: Boolean) {
        prefManager.setLoggedIn(loggedIn)
    }
}