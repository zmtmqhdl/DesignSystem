package com.example.domain.model.domain

data class ProductsDomain(
    val productList: List<ProductDomain>,
    val updatedProductList: List<ProductDomain>,
    val nextCursor: Int?,
    val previousCursor: Int?
)