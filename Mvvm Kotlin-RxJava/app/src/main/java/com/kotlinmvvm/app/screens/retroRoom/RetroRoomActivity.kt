package com.kotlinmvvm.app.screens.retroRoom

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlinmvvm.app.core.base.BaseActivity
import com.kotlinmvvm.app.models.users.DataItem
import kotlinx.android.synthetic.main.activity_retro_room.*
import javax.inject.Inject
import android.widget.Toast
import com.kotlinmvvm.app.R
import com.kotlinmvvm.app.models.users.UserList
import com.kotlinmvvm.app.utils.*


class RetroRoomActivity : BaseActivity<UserListViewModel>() {

    private lateinit var viewModel: UserListViewModel
    @Inject
    lateinit var useradater: UserAdapater
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val userList = ArrayList<DataItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro_room)
        initViews()
    }

    private fun initViews() {
        initRecylerView()
        subscribeObservers()
    }

    private fun initRecylerView() {
        rvUsers?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvUsers.setAdapter(useradater)
    }

    private fun subscribeObservers() {
        // by rxjava pattern
        viewModel.getUserListByRxJava("1").observe(this, Observer {
            consumeResponse(it)
        })

    }

    private fun consumeResponse(response: Resource<UserList>) {

        when (response.status) {
            Status.LOADING -> showProgressDialog()
            Status.SUCCESS -> {
                hideProgressDialog()
                renderSuccessResponse(response.data)
            }
            Status.ERROR -> {
                hideProgressDialog()
                Toast.makeText(this@RetroRoomActivity, "nertwork error", Toast.LENGTH_SHORT).show()
            }

            else -> {
            }
        }
    }

    private fun renderSuccessResponse(data: UserList?) {
        data.let {
            it.let {
                it?.data.let {
                    if (it != null) {
                        for (user in it) {
                            user?.let { it1 -> userList.add(it1) }
                        }
                        useradater.setCategoryList(userList)
                    }
                }
            }

        }

    }

    override fun getViewModel(): UserListViewModel {
        viewModel = ViewModelProviders.of(this, factory).get(UserListViewModel::class.java)
        return viewModel
    }
}
