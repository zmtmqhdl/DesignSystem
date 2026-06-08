package com.example.data.api

import com.example.data.model.dto.AccountDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface UserApi {
    @GET("/get")
    suspend fun getAccount(
        @Body accountDto: AccountDto
    ): AccountDto

    @POST("/post")
    suspend fun createRoom(
        @Body accountDto: AccountDto
    ): AccountDto

    @PUT("/put")
    suspend fun putAccount(
        @Body accountDto: AccountDto
    ): AccountDto

    @DELETE("/delete")
    suspend fun deleteAccount(
        @Body accountDto: AccountDto
    )
}