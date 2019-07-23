package com.kotlinmvvm.app.core.base


import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity<T : ViewModel> : DaggerAppCompatActivity() {

    private var viewModel: T? = null
    private lateinit var mProgressDialog: ProgressDialog

    /**
     * @return view model instance
     */
    abstract fun getViewModel(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = if (viewModel == null) getViewModel() else viewModel
        mProgressDialog = ProgressDialog(this)
    }

    fun showProgressDialog() {
        mProgressDialog?.show()
    }

    fun hideProgressDialog() {
        mProgressDialog?.dismiss()
    }

}
