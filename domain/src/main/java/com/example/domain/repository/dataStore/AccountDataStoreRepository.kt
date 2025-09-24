package com.example.domain.repository.dataStore

import kotlinx.coroutines.flow.Flow

interface AccountDataStoreRepository {
    val currentAccountId: Flow<Long?>
}