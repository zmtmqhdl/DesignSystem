package com.example.data.repository

import com.example.data.room.ExampleEntity

interface ExampleRepository {
    suspend fun insertUser(user: ExampleEntity)
    suspend fun getUserById(id: Int): ExampleEntity?
}