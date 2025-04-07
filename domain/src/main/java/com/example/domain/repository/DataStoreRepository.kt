package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    val testFlag: Flow<Boolean>
    suspend fun setTestFlag(enabled: Boolean)
}