package com.example.data.repositoryImpl

import com.example.data.mapper.toDomain
import com.example.data.mapper.toDto
import com.example.data.api.RetrofitApi
import com.example.domain.repository.RetrofitData
import com.example.domain.repository.RetrofitRepository

class RetrofitRepositoryImpl(private val retrofitApi: RetrofitApi) : RetrofitRepository {
    override suspend fun get(postId: Int): RetrofitData {
        return retrofitApi.get(postId).toDomain()
    }

    override suspend fun getQuery(userId: Int, completed: Boolean): List<RetrofitData> {
        return retrofitApi.getQuery(userId, completed).map { it.toDomain() }
    }

    override suspend fun post(newData: RetrofitData): RetrofitData {
        return retrofitApi.post(newData.toDto()).toDomain()
    }

    override suspend fun put(postId: Int, updatedExample: RetrofitData): RetrofitData {
        return retrofitApi.put(postId, updatedExample.toDto()).toDomain()
    }

    override suspend fun patch(postId: Int, partialUpdate: Map<String, Any>): RetrofitData {
        return retrofitApi.patch(postId, partialUpdate).toDomain()
    }

    override suspend fun delete(postId: Int): Boolean {
        return try {
            val response = retrofitApi.delete(postId)
            response.isSuccessful
        } catch (e: Exception) {
            false
        }
    }
}