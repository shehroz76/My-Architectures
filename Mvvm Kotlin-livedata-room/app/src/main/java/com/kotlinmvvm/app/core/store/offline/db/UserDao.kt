package com.kotlinmvvm.app.core.store.offline.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlinmvvm.app.models.users.DataItem
import javax.inject.Inject

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(userList: List<DataItem?>?)

    @Query("SELECT * FROM DataItem")
    fun finAllUsers(): LiveData<List<DataItem>>
}
