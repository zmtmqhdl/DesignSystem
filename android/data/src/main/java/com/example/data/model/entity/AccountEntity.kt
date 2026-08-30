package com.example.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.entity.key.DatabaseNames

@Entity(tableName = DatabaseNames.ACCOUNT)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
)