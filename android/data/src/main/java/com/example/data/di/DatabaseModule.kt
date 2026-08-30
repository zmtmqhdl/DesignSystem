package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.database.CommonDatabase
import com.example.data.database.dao.PagingKeyDao
import com.example.data.database.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCommonDatabase(
        @ApplicationContext context: Context
    ): CommonDatabase {
        return Room.databaseBuilder(
            context,
            CommonDatabase::class.java,
            "common_database.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: CommonDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun providePagingKeyDao(database: CommonDatabase): PagingKeyDao {
        return database.pagingKeyDao()
    }
}