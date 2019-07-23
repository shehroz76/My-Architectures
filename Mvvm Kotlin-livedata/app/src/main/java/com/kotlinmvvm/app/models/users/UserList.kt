package com.kotlinmvvm.app.models.users

data class UserList(
	val per_page: Int? = null,
	val total: Int? = null,
	val data: List<DataItem?>? = null,
	val page: Int? = null,
	val total_pages: Int? = null
)
