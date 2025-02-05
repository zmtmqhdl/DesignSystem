package com.example.data.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

data class Example(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val completed: Boolean = false
)

interface RetrofitService {
    @GET("todos/{id}")
    suspend fun getExample(@Path("id") postId: Int): Example

    @GET("todos")
    suspend fun getQueryExample(
        @Query("userId") userId: Int,
        @Query("completed") completed: Boolean
    ): List<Example>

    @POST("todos")
    suspend fun postExample(@Body newExample: Example): Example

    @PUT("todos/{id}")
    suspend fun putExample(@Path("id") postId: Int, @Body updatedExample: Example): Example

    @PATCH("todos/{id}")
    suspend fun patchExample(@Path("id") postId: Int, @Body partialUpdate: Map<String, Any>): Example

    @DELETE("todos/{id}")
    suspend fun deleteExample(@Path("id") postId: Int): Response<Unit>
}