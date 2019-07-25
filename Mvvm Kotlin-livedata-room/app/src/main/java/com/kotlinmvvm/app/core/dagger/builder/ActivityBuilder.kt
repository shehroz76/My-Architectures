package com.kotlinmvvm.app.core.dagger.builder


import com.kotlinmvvm.app.screens.home.HomeActivity
import com.kotlinmvvm.app.screens.retroRoom.RetroRoomActivity
import com.kotlinmvvm.app.screens.retroRoom.UserListModule
import com.kotlinmvvm.app.screens.splashActivity.SplashActivity
import com.kotlinmvvm.app.screens.splashActivity.SplashModule

import dagger.Module

import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashModule::class])
    internal abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [UserListModule::class])
    internal abstract fun contributeHomeActicity(): RetroRoomActivity
}