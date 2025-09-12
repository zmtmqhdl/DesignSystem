package com.example.data.repositoryImpl

import android.content.Context
import com.example.domain.repository.DataStoreRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.data.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DataStoreRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    @ApplicationScope private val appScope: CoroutineScope
) : DataStoreRepository {

    private val Context.dataStore by preferencesDataStore(name = "setting")

    companion object {
        private val TEST_FLAG_KEY = booleanPreferencesKey("test_flag")
    }

    override val testFlag: StateFlow<Boolean> = context.dataStore.data
        .map { preferences -> preferences[TEST_FLAG_KEY] == true }
        .stateIn(
            scope = appScope,
            started = SharingStarted.Eagerly,
            initialValue = false,
        )

    override suspend fun setTestFlag(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[TEST_FLAG_KEY] = enabled
        }
    }
}