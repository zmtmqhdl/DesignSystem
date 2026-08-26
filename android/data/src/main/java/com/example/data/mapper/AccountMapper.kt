package com.example.data.mapper

import com.example.data.model.dto.AccountDto
import com.example.data.model.entity.AccountEntity
import com.example.domain.model.domain.AccountDomain

fun AccountEntity.toDomain(): AccountDomain {
    return AccountDomain(
        id = id,
        name = name
    )
}

fun AccountDto.toDomain(): AccountDomain {
    return AccountDomain(
        id = id,
        name = name
    )
}

fun AccountDomain.toDto(): AccountDto {
    return AccountDto(
        id = id,
        name = name
    )
}