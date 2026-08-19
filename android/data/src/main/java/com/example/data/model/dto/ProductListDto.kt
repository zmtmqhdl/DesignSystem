package com.example.data.model.dto

import kotlinx.serialization.Serializable

// list가 끝낫을 땐? 어케 판단??
@Serializable
data class ProductListDto(
    val productList: List<ProductDto>,
    val updatedProductList: List<ProductDto>,
    val nextCursor: Int?
)