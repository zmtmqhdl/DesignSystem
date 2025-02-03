package com.example.data.repository

import com.example.data.room.UserDao
import com.example.data.room.UserEntity
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val dao: UserDao) : UserRepository {
    override suspend fun insertUser(user: UserEntity) = dao.insert(user)
    override suspend fun getUserById(id: Int): UserEntity? = dao.getUserById(id)
}