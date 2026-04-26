package com.example.data.database

import android.content.Context
import androidx.room.Room
import com.example.data.database.dao.AccountDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DatabaseProvider @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    private val accountDaoMap = mutableMapOf<Long, AppDatabase>()

    fun getDatabase(accountId: Long): AppDatabase {
        return accountDaoMap.getOrPut(accountId) {
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "database_$accountId"
            ).build()
        }
    }


    fun accountDao(accountId: Long): AccountDao {
        return getDatabase(accountId = accountId).accountDao()
    }


}