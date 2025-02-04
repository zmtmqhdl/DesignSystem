package com.example.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ExampleEntity::class], version = 1, exportSchema = false)
abstract class ExampleDatabase : RoomDatabase() {
    abstract fun userDao(): ExampleDao
}

