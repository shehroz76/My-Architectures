package com.kotlinmvvm.app.core.store.offline.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kotlinmvvm.app.models.users.DataItem

@Database(entities = [DataItem::class], version = 1)
abstract class MvvmDb : RoomDatabase() {

    abstract fun userDao(): UserDao
}
