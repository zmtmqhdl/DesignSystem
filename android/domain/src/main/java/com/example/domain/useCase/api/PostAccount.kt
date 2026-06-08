package com.example.domain.useCase.api

import com.example.domain.model.AccountDomain
import com.example.domain.repository.api.AccountApiRepository
import jakarta.inject.Inject

class PostAccount @Inject constructor(
    private val accountApiRepository: AccountApiRepository
) {
    suspend operator fun invoke(
        accountDomain: AccountDomain
    ): Result<AccountDomain> {
        return accountApiRepository.postAccount(
            accountDomain = accountDomain
        ).onSuccess {

        }.onFailure { e ->

        }
    }
}