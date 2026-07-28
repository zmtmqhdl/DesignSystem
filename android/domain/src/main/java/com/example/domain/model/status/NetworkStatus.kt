package com.example.domain.model.status

sealed interface NetworkStatus {
    data object Disconnected : NetworkStatus
    data object Switching : NetworkStatus
    data class Connected(
        val type: NetworkType,
        val isMetered: Boolean
    ) : NetworkStatus
}

enum class NetworkType {
    WIFI, CELLULAR, ETHERNET, OTHER
}