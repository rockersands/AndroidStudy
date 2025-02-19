package com.example.cleanarch3.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarch3.presentation.posts.data.local.PostDao
import com.example.cleanarch3.presentation.posts.data.local.PostEntity

@Database(
    entities = [PostEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
