package com.example.data.api

import com.example.data.model.dto.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("/get/product/{cursor}/{direction}/{size}")
    suspend fun getProductList(
        @Path("cursor") cursor: Int,
        @Path("direction") direction: String,
        @Path("size") size: Int
    ): ProductsDto
}