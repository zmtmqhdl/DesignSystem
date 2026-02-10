package com.example.domain.repository.database

import com.example.domain.model.state.AccountListState
import com.example.domain.model.state.AccountState
import kotlinx.coroutines.flow.Flow

interface AccountDatabaseRepository {
    val accountList: Flow<AccountListState>
    val currentAccount: Flow<AccountState>
}
