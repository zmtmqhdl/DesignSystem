package com.example.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface DataStoreRepository {
    val testFlag: StateFlow<Boolean>
    suspend fun setTestFlag(enabled: Boolean)
}