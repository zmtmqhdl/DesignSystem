package com.example.data.mapper

import com.example.data.model.entity.AccountEntity
import com.example.domain.model.domain.AccountDomain

fun AccountEntity.toDomain() =
    AccountDomain(
        id = id,
        name = name
    )