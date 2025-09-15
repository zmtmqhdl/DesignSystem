package com.example.data.model.mapper

import com.example.data.model.dto.AccountDto
import com.example.data.model.entity.AccountEntity
import com.example.domain.model.AccountDomain

fun AccountDto.toDomain() =
    AccountDomain(
        id = id,
        name = name
    )

fun AccountDto.toEntity() =
    AccountEntity(
        id = id,
        name = name
    )