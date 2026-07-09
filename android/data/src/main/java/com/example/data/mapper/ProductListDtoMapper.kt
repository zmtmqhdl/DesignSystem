package com.example.data.mapper

import com.example.data.model.dto.ProductListDto
import com.example.domain.model.ProductListDomain

fun ProductListDto.toDomain(): ProductListDomain {
    return ProductListDomain(
        productList = productList.map { it.toDomain() },
        prevCursor = prevCursor,
        nextCursor = nextCursor
    )
}