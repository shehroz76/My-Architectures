package com.kotlinmvvm.app.screens.loginActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotlinmvvm.app.R
import com.kotlinmvvm.app.screens.home.HomeActivity
import com.kotlinmvvm.app.screens.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    private fun initViews() {
        register.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        })

        signIn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        })
    }
}
