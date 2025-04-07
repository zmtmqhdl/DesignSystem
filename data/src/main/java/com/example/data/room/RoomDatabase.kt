package com.example.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.RoomEntity

@Database(entities = [RoomEntity::class], version = 1, exportSchema = false)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun userDao(): RoomDao
}

