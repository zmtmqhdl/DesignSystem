package com.example.domain.model.state

import com.example.domain.model.AccountDomain

sealed class AccountListState {
    object Loading : AccountListState()
    object Empty : AccountListState()
    data class Loaded(val accounts: List<AccountDomain>) : AccountListState()
}