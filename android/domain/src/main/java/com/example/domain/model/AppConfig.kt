package com.example.domain.model

data class AppConfig(
    val isDev: Boolean,
    val baseUrl: String,
    val enableLogging: Boolean,
)