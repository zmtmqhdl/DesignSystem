package com.example.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductListDto(
    val productList: List<ProductDto>,
    val updatedProductList: List<ProductDto>,
    val lastCursor: Int?
)