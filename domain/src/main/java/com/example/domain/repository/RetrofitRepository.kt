package com.example.domain.repository

interface RetrofitRepository {
    suspend fun get(postId: Int): RetrofitData
    suspend fun getQuery(userId: Int, completed: Boolean): List<RetrofitData>
    suspend fun post(newExample: RetrofitData): RetrofitData
    suspend fun put(postId: Int, updatedExample: RetrofitData): RetrofitData
    suspend fun patch(postId: Int, partialUpdate: Map<String, Any>): RetrofitData
    suspend fun delete(postId: Int): Boolean
}