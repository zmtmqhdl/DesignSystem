package com.example.domain.repository.dataStore

import kotlinx.coroutines.flow.StateFlow

interface AccountDataStoreRepository {
    val currentAccountId: StateFlow<Long>
}