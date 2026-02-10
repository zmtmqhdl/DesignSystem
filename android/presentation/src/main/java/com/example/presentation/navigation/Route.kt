package com.example.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Route : NavKey {
    @Serializable
    data object Main: Route

    @Serializable
    data object First: Route

    @Serializable
    data object Second: Route

    @Serializable
    data class Test(val id: Int) : Route
}