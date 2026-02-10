package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.AccountDao
import com.example.data.model.entity.AccountEntity

@Database(
    entities = [AccountEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}

