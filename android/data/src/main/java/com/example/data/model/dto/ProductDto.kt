package com.example.data.model.dto

import kotlinx.serialization.Serializable


@Serializable
data class ProductDto(
    val id: Long,
    val name: String,
    val price: Long,
    val imageUrl: String
)