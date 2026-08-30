package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.data.model.entity.AccountEntity
import com.example.data.model.entity.key.DatabaseNames
import kotlinx.coroutines.flow.Flow

@Dao
interface  AccountDao {
    @Query("SELECT * FROM ${DatabaseNames.ACCOUNT}")
    fun getAccountList(): Flow<List<AccountEntity>>
}