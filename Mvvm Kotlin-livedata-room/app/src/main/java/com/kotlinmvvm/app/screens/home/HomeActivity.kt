package com.kotlinmvvm.app.screens.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotlinmvvm.app.R
import com.kotlinmvvm.app.screens.retroRoom.RetroRoomActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
    }

    private fun initViews() {
        retroRoom.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HomeActivity, RetroRoomActivity::class.java))
        })
    }
}
