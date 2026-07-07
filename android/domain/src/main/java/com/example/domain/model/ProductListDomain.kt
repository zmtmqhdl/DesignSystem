package com.example.domain.model

data class ProductListDomain(
    val productList: List<ProductDomain>,
    val prevCursor: Int?,
    val nextCursor: Int?
)