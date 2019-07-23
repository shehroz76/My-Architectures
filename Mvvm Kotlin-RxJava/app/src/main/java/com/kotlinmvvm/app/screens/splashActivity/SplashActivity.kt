package com.kotlinmvvm.app.screens.splashActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kotlinmvvm.app.R
import com.kotlinmvvm.app.core.base.BaseActivity
import com.kotlinmvvm.app.screens.loginActivity.LoginActivity
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashViewModel>() {

    private lateinit var viewModel: SplashViewModel
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val SPLASH_TIME_OUT: Long = 5000 // 3 sec

    override fun getViewModel(): SplashViewModel {
        viewModel = ViewModelProviders.of(this, factory).get(SplashViewModel::class.java)
        return viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
