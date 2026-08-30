package com.example.data.mapper

import com.example.data.model.entity.PagingKeyEntity
import com.example.domain.model.domain.PagingKeyDomain

fun PagingKeyEntity.toDomain(): PagingKeyDomain {
    return PagingKeyDomain(
        name = name,
        nextCursor = nextCursor,
        previousCursor = previousCursor
    )
}

fun PagingKeyDomain.toEntity(): PagingKeyEntity {
    return PagingKeyEntity(
        name = name,
        nextCursor = nextCursor,
        previousCursor = previousCursor
    )
}