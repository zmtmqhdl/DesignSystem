package com.example.data.model.mapper

import com.example.data.model.entity.AccountEntity
import com.example.domain.model.AccountDomain

fun AccountEntity.toDomain() =
    AccountDomain(
        id = id,
        name = name
    )