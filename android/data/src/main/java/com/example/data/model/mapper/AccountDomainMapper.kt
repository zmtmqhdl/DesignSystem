package com.example.data.model.mapper

import com.example.data.model.dto.AccountDto
import com.example.data.model.entity.AccountEntity
import com.example.domain.model.AccountDomain

fun AccountDomain.toDto() =
    AccountDto(
        id = id,
        name = name
    )

fun AccountDomain.toEntity() =
    AccountEntity(
        id = id,
        name = name
    )