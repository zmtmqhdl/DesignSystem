package com.example.data.model.mapper

import com.example.data.model.dto.ProductDto
import com.example.domain.model.ProductDomain

fun ProductDto.toDomain(): ProductDomain {
    return ProductDomain(
        id = id,
        name = name,
        price = price,
        imageUrl = imageUrl
    )
}