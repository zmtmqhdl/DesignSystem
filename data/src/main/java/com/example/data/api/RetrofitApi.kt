package com.example.data.api

import com.example.data.model.RetrofitDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi {
    @GET("todos/{id}")
    suspend fun get(@Path("id") postId: Int): RetrofitDto

    @GET("todos")
    suspend fun getQuery(
        @Query("userId") userId: Int,
        @Query("completed") completed: Boolean
    ): List<RetrofitDto>

    @POST("todos")
    suspend fun post(@Body newExample: RetrofitDto): RetrofitDto

    @PUT("todos/{id}")
    suspend fun put(@Path("id") postId: Int, @Body updatedExample: RetrofitDto): RetrofitDto

    @PATCH("todos/{id}")
    suspend fun patch(@Path("id") postId: Int, @Body partialUpdate: Map<String, Any>): RetrofitDto

    @DELETE("todos/{id}")
    suspend fun delete(@Path("id") postId: Int): Response<Unit>
}