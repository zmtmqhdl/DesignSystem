package com.example.domain.model.state.account

import com.example.domain.model.domain.AccountDomain

sealed class AccountListState {
    object Loading : AccountListState()
    object Empty : AccountListState()
    data class Loaded(val accounts: List<AccountDomain>) : AccountListState()
}