package com.example.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

interface ApiService {
    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): PostResponse
}