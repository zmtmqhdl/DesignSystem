package com.example.data.repository

import com.example.data.room.ExampleDao
import com.example.data.room.ExampleEntity
import javax.inject.Inject

class ExampleRepositoryImplementation @Inject constructor(private val dao: ExampleDao) : ExampleRepository {
    override suspend fun insertUser(user: ExampleEntity) {
        dao.insert(user)
    }

    override suspend fun getUserById(id: Int): ExampleEntity? {
        return dao.getUserById(id)
    }
}