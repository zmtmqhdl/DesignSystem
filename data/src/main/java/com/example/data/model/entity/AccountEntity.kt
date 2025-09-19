package com.example.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account_database")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
)