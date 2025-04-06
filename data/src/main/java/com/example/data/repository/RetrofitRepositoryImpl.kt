package com.example.data.repository

import com.example.data.mapper.toDomain
import com.example.data.mapper.toDto
import com.example.data.model.RetrofitDataDto
import com.example.data.retrofit.RetrofitService
import com.example.domain.repository.RetrofitData
import com.example.domain.repository.RetrofitRepository

class RetrofitRepositoryImpl(private val retrofitService: RetrofitService) : RetrofitRepository {
    override suspend fun get(postId: Int): RetrofitData {
        return retrofitService.get(postId).toDomain()
    }

    override suspend fun getQuery(userId: Int, completed: Boolean): List<RetrofitData> {
        return retrofitService.getQuery(userId, completed).map { it.toDomain() }
    }

    override suspend fun post(newData: RetrofitData): RetrofitData {
        return retrofitService.post(newData.toDto()).toDomain()
    }

    override suspend fun put(postId: Int, updatedExample: RetrofitData): RetrofitData {
        return retrofitService.put(postId, updatedExample.toDto()).toDomain()
    }

    override suspend fun patch(postId: Int, partialUpdate: Map<String, Any>): RetrofitData {
        return retrofitService.patch(postId, partialUpdate).toDomain()
    }

    override suspend fun delete(postId: Int): Boolean {
        return try {
            val response = retrofitService.delete(postId)
            response.isSuccessful
        } catch (e: Exception) {
            false
        }
    }
}