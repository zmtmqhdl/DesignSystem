package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.data.model.entity.AccountEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface  AccountDao {
    @Query("SELECT * FROM account_database")
    fun getAccountList(): Flow<List<AccountEntity>>
}