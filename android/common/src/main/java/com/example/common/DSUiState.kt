package com.example.common

sealed interface DSUiState<out T> {
    data object Loading : DSUiState<Nothing>
    data class Success<T>(val data: T) : DSUiState<T>
    data class Error(val exception: Throwable? = null) : DSUiState<Nothing>
}