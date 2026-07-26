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
                isDev = true,
                baseUrl = "https://dev-api.com",
                enableLogging = true,
            )
        } else {
            AppConfig(
                isDev = false,
                baseUrl = "https://api.com",
                enableLogging = false,
            )
        }
    }
}