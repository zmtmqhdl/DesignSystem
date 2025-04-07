package com.example.domain.repository

import com.example.domain.model.RoomData

interface RoomRepository {
    suspend fun insertUser(user: RoomData)
    suspend fun getUserById(id: Int): RoomData?
}