package com.example.domain.common

sealed class DatabaseResponse<out T> {
    data class Success<T>(val data: T): DatabaseResponse<T>()
    data class Failure(val e: Exception): DatabaseResponse<Nothing>()
}

inline fun <reified T> DatabaseResponse<T>.onSuccess(action: (data: T) -> Unit): DatabaseResponse<T> {
    if (this is DatabaseResponse.Success) action(data)
    return this
}

inline fun <reified T> DatabaseResponse<T>.onFailure(action: (e: Exception) -> Unit): DatabaseResponse<T> {
    if (this is DatabaseResponse.Failure) action(e)
    return this
}

suspend fun <T> databaseRequest(call: suspend () -> T): DatabaseResponse<T> =
    try {
        val result = call()
        DatabaseResponse.Success(result)
    } catch (e: Exception) {
        DatabaseResponse.Failure(e)
    }

inline fun <reified T, reified R> DatabaseResponse<T>.map(transform: (T) -> R): DatabaseResponse<R> {
    return when (this) {
        is DatabaseResponse.Success -> DatabaseResponse.Success(transform(data))
        is DatabaseResponse.Failure -> this
    }
}