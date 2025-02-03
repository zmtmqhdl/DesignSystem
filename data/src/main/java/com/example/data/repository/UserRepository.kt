package com.example.data.repository

import com.example.data.room.UserEntity

interface UserRepository {
    suspend fun insertUser(user: UserEntity)
    suspend fun getUserById(id: Int): UserEntity?
}