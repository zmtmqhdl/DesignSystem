package com.example.data.model.dto

import kotlinx.serialization.Serializable


@Serializable
data class AccountDto (
    val id: Long,
    val name: String,
) {
}