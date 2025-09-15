package com.example.data.repositoryImpl.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.data.di.ApplicationScope
import com.example.data.proto.CurrentAccountProto
import com.example.data.protoSerializer.currentAccountDataStore
import com.example.domain.repository.dataStore.AccountDataStoreRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.io.IOException
import javax.inject.Inject

class AccountDataStoreRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    @ApplicationScope private val appScope: CoroutineScope
): AccountDataStoreRepository{
    private val dataStore: DataStore<CurrentAccountProto> = context.currentAccountDataStore

    override val currentAccountId: StateFlow<Long> =
        dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(CurrentAccountProto.getDefaultInstance())
                } else {
                    throw exception
                }
            }
            .map { proto -> proto.currentAccountId}
            .stateIn(
                scope = appScope,
                started = SharingStarted.Eagerly,
                initialValue = CurrentAccountProto.getDefaultInstance().currentAccountId
            )


}