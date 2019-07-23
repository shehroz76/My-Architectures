package com.kotlinmvvm.app.core.dagger.modules

import android.content.Context
import com.google.gson.Gson
import com.kotlinmvvm.app.App
import com.kotlinmvvm.app.core.store.MainAppStore
import com.kotlinmvvm.app.core.store.offline.OfflineStore
import com.kotlinmvvm.app.core.store.online.OnlineStore
import com.kotlinmvvm.app.utils.Utils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: App): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideMainAppStore(onlineStore: OnlineStore, offlineStore: OfflineStore): MainAppStore {
        return MainAppStore(onlineStore, offlineStore)

    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideUtils(context: Context): Utils {
        return Utils(context)
    }


}