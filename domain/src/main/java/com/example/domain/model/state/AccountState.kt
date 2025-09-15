package com.example.domain.model.state

import com.example.domain.model.AccountDomain

sealed class AccountState {
    object Loading : AccountState()
    object Empty : AccountState()
    data class Loaded(val account: AccountDomain) : AccountState()
}