package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.model.entity.PagingKeyEntity
import com.example.data.model.entity.key.DatabaseNames

@Dao
interface PagingKeyDao {
    @Query("SELECT * FROM ${DatabaseNames.PAGING_KEY} WHERE name = :name")
    suspend fun getPagingKey(name: String): PagingKeyEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPagingKey(pagingKey: PagingKeyEntity)

    @Update
    suspend fun updatePagingKey(pagingKey: PagingKeyEntity)
}