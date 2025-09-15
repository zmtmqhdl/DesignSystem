package com.example.data.di

import com.example.data.repositoryImpl.DataStoreRepositoryImpl
import com.example.data.repositoryImpl.UiFlowRepositoryImpl
import com.example.data.repositoryImpl.api.AccountApiRepositoryImpl
import com.example.data.repositoryImpl.WebSocketRepositoryImpl
import com.example.data.repositoryImpl.dataStore.AccountDataStoreRepositoryImpl
import com.example.domain.repository.DataStoreRepository
import com.example.domain.repository.UiFlowRepository
import com.example.domain.repository.api.AccountApiRepository
import com.example.domain.repository.WebSocketRepository
import com.example.domain.repository.dataStore.AccountDataStoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUiFlowRepository(impl: UiFlowRepositoryImpl): UiFlowRepository

    @Binds
    @Singleton
    abstract fun bindWebSocketRepository(impl: WebSocketRepositoryImpl): WebSocketRepository

    @Binds
    @Singleton
    abstract fun bindAccountApiRepository(impl: AccountApiRepositoryImpl): AccountApiRepository

    @Binds
    @Singleton
    abstract fun bindDataStoreRepository(impl: DataStoreRepositoryImpl): DataStoreRepository

    @Binds
    @Singleton
    abstract fun bindAccountDataStoreRepository(impl: AccountDataStoreRepositoryImpl): AccountDataStoreRepository
}