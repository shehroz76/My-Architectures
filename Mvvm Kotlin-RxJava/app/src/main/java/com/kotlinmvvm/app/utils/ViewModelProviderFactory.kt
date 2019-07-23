package com.kotlinmvvm.app.utils


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelProviderFactory<V:Any>(private val viewModel: V) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (viewModel != null) {
            if (modelClass.isAssignableFrom(viewModel.javaClass)) {
                return viewModel as T
            }
        }
        throw IllegalArgumentException("Unknown class name")
    }
}

//class CryptoCurrencyViewModelFactory @Inject constructor(
//    private val cryptoCurrencyViewModel: CryptoCurrencyViewModel) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(CryptoCurrencyViewModel::class.java)) {
//            return cryptoCurrencyViewModel as T
//        }
//        throw IllegalArgumentException("Unknown class name")
//    }
//}
