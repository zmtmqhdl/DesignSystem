package com.example.designsystem.di

import android.content.Context
import androidx.room.Room
import com.example.data.room.ExampleDatabase
import com.example.data.room.RoomDao
import com.example.data.repository.RoomRepository
import com.example.data.repository.RoomRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

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
    fun provideExampleDao(database: ExampleDatabase): RoomDao {
        return database.userDao()
    }

    @Provides
    fun provideExampleRepository(dao: RoomDao): RoomRepository {
        return RoomRepositoryImpl(dao)
    }
}