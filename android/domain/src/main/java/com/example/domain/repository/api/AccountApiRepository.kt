package com.example.domain.repository.api

import com.example.domain.model.domain.AccountDomain

interface AccountApiRepository {
//    suspend fun getAccount(accountDomain: AccountDomain): ApiResponse<AccountDomain>
//
//    suspend fun createAccount(accountDomain: AccountDomain): ApiResponse<AccountDomain>
//
//    suspend fun putAccount(accountDomain: AccountDomain): ApiResponse<AccountDomain>
//
//    suspend fun deleteAccount(accountDomain: AccountDomain): ApiResponse<Unit>

    suspend fun getAccount(): Result<AccountDomain>

    suspend fun postAccount(
        accountDomain: AccountDomain
    ): Result<AccountDomain>

    suspend fun putAccount(
        accountDomain: AccountDomain
    ): Result<AccountDomain>

    suspend fun deleteAccount(
        accountDomain: AccountDomain
    ): Result<Unit>
}