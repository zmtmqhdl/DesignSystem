package com.example.data.factory

import com.example.data.repositoryImpl.database.AccountDatabaseRepositoryImpl
import dagger.assisted.AssistedFactory

@AssistedFactory
interface AccountDatabaseRepositoryFactory {
    fun create(accountId: Long? = null): AccountDatabaseRepositoryImpl
}