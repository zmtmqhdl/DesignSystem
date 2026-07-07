package com.example.domain.useCase.api

import com.example.domain.model.AccountDomain
import com.example.domain.repository.api.AccountApiRepository
import javax.inject.Inject

class GetAccount @Inject constructor(
    private val accountApiRepository: AccountApiRepository
) {
//    suspend operator fun invoke(
//        accountDomain: AccountDomain
//    ): ApiResponse<AccountDomain> {
//        return accountApiRepository.getAccount(
//            accountDomain = accountDomain
//        )
//    }

    suspend operator fun invoke(
        accountDomain: AccountDomain
    ): Result<AccountDomain> {
        return accountApiRepository.getAccount().onSuccess {

        }.onFailure { e ->


        }
    }
}