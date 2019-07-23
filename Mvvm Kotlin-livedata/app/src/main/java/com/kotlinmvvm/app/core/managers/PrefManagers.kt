package com.kotlinmvvm.app.core.managers

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.kotlinmvvm.app.models.UserProfile
import com.kotlinmvvm.app.utils.Constants
import javax.inject.Inject

class PrefManagers @Inject constructor(val context: Context, val gson: Gson) {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    init {
        sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.apply()
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor.putBoolean(Constants.IS_FIRST_TIME_LAUNCH, isFirstTime)
        editor.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return sharedPreferences.getBoolean(Constants.IS_FIRST_TIME_LAUNCH, true)
    }

    fun cacheUser(profile: UserProfile) {
        val user = gson.toJson(profile)
        editor.putString(Constants.CACHED_USER, user)
    }

    fun getCachedUser(): UserProfile {
        val user = sharedPreferences.getString(Constants.CACHED_USER, null)
        return gson.fromJson<Any>(user, UserProfile::class.java) as UserProfile
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(Constants.LOGGED_IN, false)
    }

    fun setLoggedIn(isLoggedIn: Boolean) {
        editor.putBoolean(Constants.LOGGED_IN, isLoggedIn)
        editor.commit()
    }
}