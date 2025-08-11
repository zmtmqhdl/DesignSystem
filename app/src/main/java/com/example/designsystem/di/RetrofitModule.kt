package com.example.designsystem.di

import com.example.data.repositoryImpl.RetrofitRepositoryImpl
import com.example.data.client.RetrofitClient
import com.example.data.api.RetrofitApi
import com.example.domain.repository.RetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofitService(): RetrofitApi {
        return RetrofitClient.retrofitApi
    }

    @Provides
    @Singleton
    fun provideRetrofitRepository(retrofitApi: RetrofitApi): RetrofitRepository {
        return RetrofitRepositoryImpl(retrofitApi)
    }
}