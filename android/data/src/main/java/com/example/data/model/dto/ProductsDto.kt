package com.example.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductsDto(
    val products: List<ProductDto>,
    val updatedProducts: List<ProductDto>,
    val topCursor: Int?,
    val bottomCursor: Int?
)