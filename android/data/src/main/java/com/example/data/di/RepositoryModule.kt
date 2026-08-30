package com.example.data.di

import com.example.data.repositoryImpl.AccountRepositoryImpl
import com.example.data.repositoryImpl.DataStoreRepositoryImpl
import com.example.data.repositoryImpl.DeviceAuthRepositoryImpl
import com.example.data.repositoryImpl.NetworkRepositoryImpl
import com.example.data.repositoryImpl.ProductRepositoryImpl
import com.example.data.repositoryImpl.WebSocketRepositoryImpl
import com.example.domain.repository.AccountRepository
import com.example.domain.repository.DataStoreRepository
import com.example.domain.repository.DeviceAuthRepository
import com.example.domain.repository.NetworkRepository
import com.example.domain.repository.ProductRepository
import com.example.domain.repository.WebSocketRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // dataStore


    @Binds
    @Singleton
    abstract fun bindWebSocketRepository(impl: WebSocketRepositoryImpl): WebSocketRepository

    @Binds
    @Singleton
    abstract fun bindDataStoreRepository(impl: DataStoreRepositoryImpl): DataStoreRepository


    @Binds
    @Singleton
    abstract fun bindNetworkRepository(impl: NetworkRepositoryImpl): NetworkRepository


    @Binds
    @Singleton
    abstract fun bindDeviceAuthRepository(impl: DeviceAuthRepositoryImpl): DeviceAuthRepository

    @Binds
    @Singleton
    abstract fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository

    @Binds
    @Singleton
    abstract fun bindAccountRepository(
        accountRepositoryImpl: AccountRepositoryImpl
    ): AccountRepository
}