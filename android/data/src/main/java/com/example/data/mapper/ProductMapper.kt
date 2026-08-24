package com.example.data.mapper

import com.example.data.model.dto.ProductDto
import com.example.data.model.entity.ProductEntity
import com.example.domain.model.domain.ProductDomain

fun ProductEntity.toDomain(): ProductDomain {
    return ProductDomain(
        id = id,
        name = name,
        price = price,
        imageUrl = imageUrl
    )
}

fun ProductDto.toDomain(): ProductDomain {
    return ProductDomain(
        id = id,
        name = name,
        price = price,
        imageUrl = imageUrl
    )
}

fun ProductDomain.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        name = name,
        price = price,
        imageUrl = imageUrl
    )
}
