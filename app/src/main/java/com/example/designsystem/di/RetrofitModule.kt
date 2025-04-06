package com.example.designsystem.di

import com.example.data.repository.RetrofitRepositoryImpl
import com.example.data.retrofit.RetrofitClient
import com.example.data.retrofit.RetrofitService
import com.example.domain.repository.RetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitService(): RetrofitService {
        return RetrofitClient.retrofitService
    }

    @Provides
    @Singleton
    fun provideRetrofitRepository(retrofitService: RetrofitService): RetrofitRepository {
        return RetrofitRepositoryImpl(retrofitService)
    }
}