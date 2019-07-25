package com.kotlinmvvm.app.models.users

import androidx.room.Entity
import androidx.room.Ignore

//@Entity
data class UserList(
    val per_page: Int? = null,
    val total: Int? = null,
//    @Ignore
    val data: List<DataItem?>? = null,
    val page: Int? = null,
    val total_pages: Int? = null
)
