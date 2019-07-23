package com.kotlinmvvm.app.core.dagger.components

import com.kotlinmvvm.app.App
import com.kotlinmvvm.app.core.dagger.builder.ActivityBuilder
import com.kotlinmvvm.app.core.dagger.modules.AppModule
import com.kotlinmvvm.app.core.dagger.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(AndroidSupportInjectionModule::class),
        (AppModule::class),
        (NetworkModule::class),
        (ActivityBuilder::class)
    ]
)
interface AppMainComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {}
}

