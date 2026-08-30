package com.example.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.entity.key.DatabaseNames

@Entity(tableName = DatabaseNames.PAGING_KEY)
data class PagingKeyEntity (
    @PrimaryKey val name: String,
    val nextCursor: Long?,
    val previousCursor: Long?
)