package com.example.data.di

import com.example.data.repositoryImpl.DataStoreRepositoryImpl
import com.example.data.repositoryImpl.UiFlowRepositoryImpl
import com.example.data.repositoryImpl.RetrofitRepositoryImpl
import com.example.data.repositoryImpl.WebSocketRepositoryImpl
import com.example.domain.repository.DataStoreRepository
import com.example.domain.repository.UiFlowRepository
import com.example.domain.repository.RetrofitRepository
import com.example.domain.repository.WebSocketRepository
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
    abstract fun bindLoadingRepository(impl: UiFlowRepositoryImpl): UiFlowRepository

    @Binds
    @Singleton
    abstract fun bindWebSocketRepository(impl: WebSocketRepositoryImpl): WebSocketRepository

    @Binds
    @Singleton
    abstract fun bindRetrofitRepository(impl: RetrofitRepositoryImpl): RetrofitRepository

    @Binds
    @Singleton
    abstract fun bindDataStoreRepository(impl: DataStoreRepositoryImpl): DataStoreRepository
}