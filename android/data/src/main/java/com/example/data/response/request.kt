package com.example.data.response

import com.example.domain.response.ApiResponse

suspend fun <T> request(block: suspend () -> T): ApiResponse<T> {
    return runCatching { block() }
        .fold(
            onSuccess = { ApiResponse.Success(it) },
            onFailure = { ApiResponse.Error(it) }
        )
}

inline fun <reified T, reified R> ApiResponse<T>.map(transform: (T) -> R): ApiResponse<R> {
    return when (this) {
        is ApiResponse.Success -> ApiResponse.Success(transform(data))
        is ApiResponse.Error -> this
    }
}