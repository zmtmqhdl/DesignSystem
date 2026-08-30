package com.example.designsystem.di

import com.example.designsystem.BuildConfig
import com.example.domain.model.AppConfig
import com.example.domain.model.Environment
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
        return if (BuildConfig.FLAVOR == "prod") {
            AppConfig(
                environment = Environment.PROD,
                baseUrl = "https://api.com/",
            )
        } else {
            AppConfig(
                environment = Environment.DEV,
                baseUrl = "https://dev-api.com/",
            )
        }
    }
}