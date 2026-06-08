package com.example.domain.response

/*
kotlin이 제공하는 result<T>와 ApiResponse의 차이점이 없음
그래서 현재 Result 사용
 */


sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Error(val throwable: Throwable) : ApiResponse<Nothing>()
}

inline fun <T> ApiResponse<T>.onSuccess(action: (T) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Success) action(data)
    return this
}

inline fun <T> ApiResponse<T>.onFailure(action: (Throwable) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Error) action(throwable)
    return this
}

