package com.example.data.di

import com.example.domain.model.AppConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BasicRetrofit

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @BasicRetrofit
    @Singleton
    @Provides
    fun provideRetrofit(
        appConfig: AppConfig
    ): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (appConfig.enableLogging) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
        val json = Json { ignoreUnknownKeys = true }
        val client = OkHttpClient.Builder()
            .connectTimeout(
                timeout = 10,
                unit = TimeUnit.SECONDS
            )
            .readTimeout(
                timeout = 10,
                unit = TimeUnit.SECONDS
            )
            .writeTimeout(
                timeout = 10,
                unit = TimeUnit.SECONDS
            )
            .addInterceptor(interceptor = loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(appConfig.baseUrl)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}