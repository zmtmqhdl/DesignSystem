package com.example.data.repositoryImpl.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.data.proto.CurrentAccountProto
import com.example.data.protoSerializer.currentAccountDataStore
import com.example.domain.repository.dataStore.AccountDataStoreRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class AccountDataStoreRepositoryImpl @Inject constructor(
    @param:ApplicationContext private val context: Context,
): AccountDataStoreRepository{

    private val dataStore: DataStore<CurrentAccountProto> = context.currentAccountDataStore

    override val currentAccountId: Flow<Long?> =
        dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(CurrentAccountProto.getDefaultInstance())
                } else {
                    throw exception
                }
            }
            .map { proto ->
                if (proto.hasCurrentAccountId()) proto.currentAccountId.value else null
            }
}