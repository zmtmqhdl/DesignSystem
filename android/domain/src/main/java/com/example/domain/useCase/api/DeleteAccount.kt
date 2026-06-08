package com.example.domain.useCase.api

import com.example.domain.model.AccountDomain
import com.example.domain.repository.api.AccountApiRepository
import jakarta.inject.Inject

class DeleteAccount @Inject constructor(
    private val accountApiRepository: AccountApiRepository
) {
    suspend operator fun invoke(
        accountDomain: AccountDomain
    ): Result<Unit> {
        return accountApiRepository.deleteAccount(
            accountDomain = accountDomain
        ).onSuccess {

        }.onFailure { e ->

        }
    }
}