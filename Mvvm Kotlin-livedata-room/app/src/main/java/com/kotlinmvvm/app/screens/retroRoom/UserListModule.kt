package com.kotlinmvvm.app.screens.retroRoom

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.kotlinmvvm.app.core.store.offline.db.UserDao
import com.kotlinmvvm.app.core.store.online.services.ApiService
import com.kotlinmvvm.app.utils.AppExecutors
import com.kotlinmvvm.app.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import java.util.ArrayList

@Module
class UserListModule {
    internal var listener: View.OnClickListener? = null

    @Provides
    fun provideViewModel(context: Context,userRepositry: UserRepositry): UserListViewModel {
        return UserListViewModel(userRepositry)
    }

    @Provides
    fun provideUserRepositry(context: Context,apiService: ApiService,appExecutors: AppExecutors,userDao: UserDao):UserRepositry{
        return UserRepositry(context,apiService,appExecutors,userDao)
    }

    @Provides
    fun provideViewModelProvider(viewModel: UserListViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }

    @Provides
    fun provideAdapter(context: Context): UserAdapater {
        return UserAdapater(context, ArrayList(), listener)
    }
}
