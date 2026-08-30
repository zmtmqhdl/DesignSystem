package com.example.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.entity.key.DatabaseNames

@Entity(tableName = DatabaseNames.PRODUCT)
data class ProductEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val price: Long,
    val imageUrl: String
)