package com.example.designsystem.di

import android.content.Context
import androidx.room.Room
import com.example.data.room.ExampleDatabase
import com.example.data.room.ExampleDao
import com.example.data.repository.ExampleRepository
import com.example.data.repository.ExampleRepositoryImplementation
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
    fun provideDatabase(@ApplicationContext context: Context): ExampleDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ExampleDatabase::class.java,
            "example_database"
        ).build()
    }

    @Provides
    fun provideExampleDao(database: ExampleDatabase): ExampleDao {
        return database.userDao()
    }

    @Provides
    fun provideExampleRepository(dao: ExampleDao): ExampleRepository {
        return ExampleRepositoryImplementation(dao)
    }
}