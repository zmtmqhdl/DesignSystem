package com.example.data.api

import com.example.data.model.dto.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {
    @GET("/get/product")
    suspend fun getProducts(
        @Query("cursor") cursor: Int?,
        @Query("direction") direction: String?,
        @Query("size") size: Int?
    ): ProductsDto
}