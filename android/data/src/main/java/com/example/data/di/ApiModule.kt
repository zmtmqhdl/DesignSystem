package com.example.data.di

import com.example.data.api.AccountApi
import com.example.data.api.FakeProductApi
import com.example.data.api.ProductApi
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
    fun provideUserApi(@BasicRetrofit retrofit: Retrofit): AccountApi {
        return provideApi(retrofit = retrofit)
    }

//    @Singleton
//    @Provides
//    fun provideProductApi(@BasicRetrofit retrofit: Retrofit): ProductApi {
//        return provideApi(retrofit = retrofit)
//    }

    @Singleton
    @Provides
    fun provideProductApi(
        fakeProductApi: FakeProductApi
    ): ProductApi {
        return fakeProductApi
    }

}

inline fun <reified I> provideApi(retrofit: Retrofit): I {
    return retrofit.create(I::class.java)
}