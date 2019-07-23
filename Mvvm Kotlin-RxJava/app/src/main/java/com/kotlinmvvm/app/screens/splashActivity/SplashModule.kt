package com.kotlinmvvm.app.screens.splashActivity

import androidx.lifecycle.ViewModelProvider
import com.kotlinmvvm.app.core.store.MainAppStore
import com.kotlinmvvm.app.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    fun provideViewModel(store: MainAppStore): SplashViewModel {
        return SplashViewModel(store)
    }


    @Provides
    internal fun provideViewModelProvider(viewModel: SplashViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }
}