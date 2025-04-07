package com.example.data.repositoryImpl

import com.example.data.mapper.toDomain
import com.example.data.mapper.toRoom
import com.example.data.room.RoomDao
import com.example.domain.model.RoomData
import com.example.domain.repository.RoomRepository
import jakarta.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val dao: RoomDao
) : RoomRepository {

    override suspend fun insertUser(user: RoomData) {
        dao.insert(user.toRoom())
    }

    override suspend fun getUserById(id: Int): RoomData? {
        return dao.getUserById(id)?.toDomain()
    }
}