package com.example.domain.repository

import com.example.domain.model.domain.AccountDomain
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    val accountLists: Flow<List<AccountDomain>>
    val currentAccountId: Flow<Long?>
    val currentAccount: Flow<AccountDomain?>

    suspend fun setCurrentAccountId(id: Long?)

    suspend fun getAccount(): Result<AccountDomain>
    suspend fun postAccount(accountDomain: AccountDomain): Result<AccountDomain>
    suspend fun putAccount(accountDomain: AccountDomain): Result<AccountDomain>
    suspend fun deleteAccount(accountDomain: AccountDomain): Result<Unit>
}