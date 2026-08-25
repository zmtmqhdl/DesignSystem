package com.example.data.mapper

import com.example.data.model.dto.ProductsDto
import com.example.domain.model.domain.ProductsDomain

fun ProductsDto.toDomain(): ProductsDomain {
    return ProductsDomain(
        productList = products.map { it.toDomain() },
        updatedProductList = updatedProducts.map { it.toDomain() },
        topCursor = topCursor,
        bottomCursor = bottomCursor
    )
}