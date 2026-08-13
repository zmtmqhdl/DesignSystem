package com.example.designsystem.di

import com.example.designsystem.BuildConfig
import com.example.domain.model.AppConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppConfig(): AppConfig {
        return if (BuildConfig.FLAVOR == "dev") {
            AppConfig(
                isProd = false,
                baseUrl = "https://dev-api.com",
            )
        } else {
            AppConfig(
                isProd = false,
                baseUrl = "https://api.com",
            )
        }
    }
}