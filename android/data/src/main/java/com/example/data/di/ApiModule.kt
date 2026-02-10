package com.example.data.di

import com.example.data.api.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideUserApi(@BasicRetrofit retrofit: Retrofit): UserApi =
        provideApi(retrofit = retrofit)

}

inline fun <reified I> provideApi(retrofit: Retrofit): I = retrofit.create(I::class.java)