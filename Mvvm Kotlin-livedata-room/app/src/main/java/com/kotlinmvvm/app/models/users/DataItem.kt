package com.kotlinmvvm.app.models.users

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataItem(
    val last_name: String? = null,
    @PrimaryKey
    val id: Int?,
    val avatar: String? = null,
    val first_name: String? = null,
    val email: String? = null
)
