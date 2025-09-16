package com.example.data.database

import android.content.Context
import androidx.room.Room
import com.example.data.database.dao.AccountDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DatabaseProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun getDatabase(accountId: Long): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "${accountId}_database"
        ).build()
    }

    fun getAccountDao(accountId: Long): AccountDao {
        return getDatabase(accountId = accountId).accountDao()
    }
}