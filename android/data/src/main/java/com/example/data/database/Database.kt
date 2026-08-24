package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.AccountDao
import com.example.data.database.dao.ProductDao
import com.example.data.model.entity.AccountEntity
import com.example.data.model.entity.ProductEntity

@Database(
    entities = [AccountEntity::class],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}

@Database(
    entities = [ProductEntity::class],
    version = 1
)
abstract class CommonDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}