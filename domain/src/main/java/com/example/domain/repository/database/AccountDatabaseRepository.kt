package com.example.domain.repository.database

import com.example.domain.model.state.AccountListState
import com.example.domain.model.state.AccountState
import kotlinx.coroutines.flow.StateFlow

interface AccountDatabaseRepository {
    val accountList: StateFlow<AccountListState>
    val currentAccount: StateFlow<AccountState>
}
