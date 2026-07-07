package com.example.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductListDto(
    val productList: List<ProductDto>,
    val prevCursor: Int?,
    val nextCursor: Int?
)