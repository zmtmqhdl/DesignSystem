package com.example.data.factory

import com.example.data.repositoryImpl.database.AccountDatabaseRepositoryImpl
import com.example.domain.model.AccountDomain
import dagger.assisted.AssistedFactory

@AssistedFactory
interface AccountDatabaseRepositoryFactory {
    fun create(accountDomain: AccountDomain? = null): AccountDatabaseRepositoryImpl
}