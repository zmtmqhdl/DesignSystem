package com.example.domain.model.domain

data class ProductListDomain(
    val productList: List<ProductDomain>,
    val updatedProductList: List<ProductDomain>,
    val lastCursor: Int?
)