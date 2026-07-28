package com.example.domain.repository

import com.example.domain.model.status.NetworkStatus
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {
    val networkStatus: Flow<NetworkStatus>
}