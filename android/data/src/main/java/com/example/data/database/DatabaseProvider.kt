package com.example.data.database

import android.content.Context
import androidx.room.Room
import com.example.data.database.dao.AccountDao
import com.example.data.database.dao.ProductDao
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

// 어떻게 처리해야할까?/
class DatabaseProvider @Inject constructor(
    @param:ApplicationContext private val context: Context
) {
    private val accountDatabaseMap = ConcurrentHashMap<Long, AppDatabase>()

    fun getDatabase(accountId: Long): AppDatabase {
        return accountDatabaseMap.getOrPut(accountId) {
            Room.databaseBuilder(
                context = context,
                klass = AppDatabase::class.java,
                name = "${accountId}_database"
            ).build()
        }
    }


    fun accountDao(accountId: Long): AccountDao {
        return getDatabase(accountId = accountId).accountDao()
    }


//    private val commonDatabase: CommonDatabase by lazy {
//        Room.databaseBuilder(
//            context = context,
//            klass = CommonDatabase::class.java,
//            name = "common_database"
//        ).build()
//    }
//
//    fun productDao(): ProductDao {
//        return commonDatabase.productDao()
//    }
}