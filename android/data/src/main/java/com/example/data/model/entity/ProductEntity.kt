package com.example.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_database")
data class ProductEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val price: Int,
    val imageUrl: String
)