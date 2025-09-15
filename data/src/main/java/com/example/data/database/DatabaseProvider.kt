package com.example.data.database

import android.content.Context
import androidx.room.Room
import com.example.data.database.dao.AccountDao
import com.example.domain.model.AccountDomain
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DatabaseProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun getDatabase(accountDomain: AccountDomain): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "${accountDomain.id}_database"
        ).build()
    }

    fun getAccountDao(accountDomain: AccountDomain): AccountDao {
        return getDatabase(accountDomain).accountDao()
    }
}