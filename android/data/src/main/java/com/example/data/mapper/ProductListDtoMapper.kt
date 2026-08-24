package com.example.data.mapper

import com.example.data.model.dto.ProductsDto
import com.example.domain.model.domain.ProductListDomain

fun ProductsDto.toDomain(): ProductListDomain {
    return ProductListDomain(
        productList = products.map { it.toDomain() },
        updatedProductList = updatedProducts.map { it.toDomain() },
        lastCursor = lastCursor
    )
}