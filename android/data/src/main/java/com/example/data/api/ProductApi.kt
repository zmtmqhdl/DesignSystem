package com.example.data.api

import com.example.data.model.dto.ProductListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {
    @GET("/get")
    suspend fun getProductList(
        @Query("cursor") cursor: Int?,
        @Query("size") size: Int,
        @Query("direction") direction: String
    ): ProductListDto
}