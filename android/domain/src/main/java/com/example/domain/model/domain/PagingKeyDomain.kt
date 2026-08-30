package com.example.domain.model.domain

data class PagingKeyDomain(
    val name: String,
    val nextCursor: Long?,
    val previousCursor: Long?
)