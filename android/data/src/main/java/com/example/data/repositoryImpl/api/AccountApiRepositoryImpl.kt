package com.example.data.repositoryImpl.api

import com.example.data.api.AccountApi
import com.example.data.mapper.toDomain
import com.example.data.mapper.toDto
import com.example.domain.model.AccountDomain
import com.example.domain.repository.api.AccountApiRepository
import javax.inject.Inject

class AccountApiRepositoryImpl @Inject constructor(
    private val accountApi: AccountApi
) : AccountApiRepository {
//    override suspend fun getAccount(accountDomain: AccountDomain): ApiResponse<AccountDomain> {
//        return request {
//            userApi.getAccount(accountDto = accountDomain.toDto()).toDomain()
//        }
//    }
//
//    override suspend fun createAccount(accountDomain: AccountDomain): ApiResponse<AccountDomain> {
//        return request {
//            userApi.createRoom(accountDto = accountDomain.toDto()).toDomain()
//        }
//    }
//
//    override suspend fun putAccount(accountDomain: AccountDomain): ApiResponse<AccountDomain> {
//        return request {
//            userApi.putAccount(accountDto = accountDomain.toDto()).toDomain()
//        }
//    }
//
//    override suspend fun deleteAccount(accountDomain: AccountDomain): ApiResponse<Unit> {
//        return request {
//            userApi.deleteAccount(accountDto = accountDomain.toDto())
//        }
//    }

    override suspend fun getAccount(): Result<AccountDomain> {
        return runCatching {
            accountApi.getAccount().toDomain()
        }
    }

    override suspend fun postAccount(
        accountDomain: AccountDomain
    ): Result<AccountDomain> {
        return runCatching {
            accountApi.createRoom(
                accountDto = accountDomain.toDto()
            ).toDomain()
        }
    }

    override suspend fun putAccount(
        accountDomain: AccountDomain
    ): Result<AccountDomain> {
        return runCatching {
            accountApi.putAccount(
                accountDto = accountDomain.toDto()
            ).toDomain()
        }
    }

    override suspend fun deleteAccount(
        accountDomain: AccountDomain
    ): Result<Unit> {
        return runCatching {
            accountApi.deleteAccount(
                accountDto = accountDomain.toDto()
            )
        }
    }
}