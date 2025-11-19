package com.example.data.database

import android.content.Context
import androidx.room.Room
import com.example.data.database.dao.AccountDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DatabaseProvider @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    private val accountDaoMap = mutableMapOf<Long, AccountDao>()

    fun getDatabase(accountId: Long): AppDatabase {
        return accountId.let { id ->
            Room.databaseBuilder(
                context = context,
                klass = AppDatabase::class.java,
                name = "database_${id}"
            ).build()
        }
    }

    fun accountDao(accountId: Long): AccountDao =
        accountDaoMap.getOrPut(key = accountId) {
            getDatabase(accountId = accountId).accountDao()
        }
}