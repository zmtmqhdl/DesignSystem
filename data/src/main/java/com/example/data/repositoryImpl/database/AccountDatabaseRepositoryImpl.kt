package com.example.data.repositoryImpl.database

import com.example.data.database.DatabaseProvider
import com.example.data.di.ApplicationScope
import com.example.data.model.mapper.toDomain
import com.example.domain.model.AccountDomain
import com.example.domain.model.state.AccountListState
import com.example.domain.model.state.AccountState
import com.example.domain.repository.database.AccountDatabaseRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlin.getValue

class AccountDatabaseRepositoryImpl @AssistedInject constructor(
    private val databaseProvider: DatabaseProvider,
    @Assisted private val accountDomain: AccountDomain,
    @ApplicationScope private val appScope: CoroutineScope
) : AccountDatabaseRepository {

    private val userDao by lazy {
        databaseProvider.getAccountDao(accountDomain)
    }

    override val accountList: StateFlow<AccountListState> =
        userDao.getAccountList()
            .map { entityList ->
                val domainList = entityList.map { it.toDomain() }
                when {
                    domainList.isEmpty() -> AccountListState.Empty
                    else -> AccountListState.Loaded(domainList)
                }
            }
            .stateIn(
                scope = appScope,
                started = SharingStarted.Eagerly,
                initialValue = AccountListState.Loading
            )

    override val activeAccount: StateFlow<AccountState> =
        accountList
            .map { state ->
                when (state) {
                    is AccountListState.Loaded -> {
                        val first = state.accounts.firstOrNull()
                        if (first != null) AccountState.Loaded(first) else AccountState.Empty
                    }
                    AccountListState.Empty -> AccountState.Empty
                    AccountListState.Loading -> AccountState.Loading
                }
            }
            .stateIn(
                scope = appScope,
                started = SharingStarted.Eagerly,
                initialValue = AccountState.Loading
            )
}
