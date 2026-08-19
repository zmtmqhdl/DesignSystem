package com.example.domain.model

enum class Environment {
    DEV, PROD
}


data class AppConfig(
    val environment: Environment,
    val baseUrl: String,
)