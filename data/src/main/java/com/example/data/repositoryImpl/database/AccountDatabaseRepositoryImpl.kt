package com.example.data.repositoryImpl.database

import com.example.data.database.DatabaseProvider
import com.example.data.model.mapper.toDomain
import com.example.domain.model.state.AccountListState
import com.example.domain.model.state.AccountState
import com.example.domain.repository.dataStore.AccountDataStoreRepository
import com.example.domain.repository.database.AccountDatabaseRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

@OptIn(ExperimentalCoroutinesApi::class)
class AccountDatabaseRepositoryImpl @AssistedInject constructor(
    @Assisted private val accountId: Long?,
    private val databaseProvider: DatabaseProvider,
    accountDataStoreRepository: AccountDataStoreRepository
) : AccountDatabaseRepository {

    private val databaseKeyId: Flow<Long> =
        accountId?.let { flowOf(it) } ?: accountDataStoreRepository.currentAccountId.filterNotNull()

    override val accountList: Flow<AccountListState> =
        databaseKeyId.flatMapLatest { id ->
            databaseProvider.accountDao(accountId = id).getAccountList()
        }.map { entityList ->
            val domainList = entityList.map { it.toDomain() }
            if (domainList.isEmpty()) AccountListState.Empty else AccountListState.Loaded(domainList)
        }.onStart { emit(AccountListState.Loading) }

    override val currentAccount: Flow<AccountState> =
        databaseKeyId.flatMapLatest { currentId ->
            accountList.map { state ->
                when (state) {
                    is AccountListState.Loaded -> {
                        val account = state.accounts.firstOrNull { it.id == currentId }
                        if (account != null) AccountState.Loaded(account) else AccountState.Empty
                    }
                    AccountListState.Empty -> AccountState.Empty
                    AccountListState.Loading -> AccountState.Loading
                }
            }
        }
}
