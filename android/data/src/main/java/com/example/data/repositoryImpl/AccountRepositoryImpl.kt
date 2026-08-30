package com.example.data.repositoryImpl

import android.content.Context
import androidx.datastore.core.DataStore
import com.example.data.api.AccountApi
import com.example.data.database.DatabaseProvider
import com.example.data.mapper.toDomain
import com.example.data.mapper.toDto
import com.example.data.proto.CurrentAccountProto
import com.example.data.protoSerializer.currentAccountDataStore
import com.example.domain.model.domain.AccountDomain
import com.example.domain.repository.AccountRepository
import com.google.protobuf.Int64Value
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
@Singleton
class AccountRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val accountApi: AccountApi,
    private val databaseProvider: DatabaseProvider,
) : AccountRepository {
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

    override suspend fun setCurrentAccountId(id: Long?) {
        dataStore.updateData { current ->
            if (id != null) {
                current.toBuilder()
                    .setCurrentAccountId(Int64Value.of(id))
                    .build()
            } else {
                current.toBuilder()
                    .clearCurrentAccountId()
                    .build()
            }
        }
    }

    // 2. Database logic
    override val accountLists: Flow<List<AccountDomain>> =
        currentAccountId.flatMapLatest { id ->
            if (id == null) {
                flowOf(emptyList())
            } else {
                databaseProvider.accountDao(accountId = id).getAccountList().map { entityList ->
                    entityList.map { it.toDomain() }
                }
            }
        }

    override val currentAccount: Flow<AccountDomain?> =
        combine(accountLists, currentAccountId) { lists, currentId ->
            if (currentId == null) null
            else lists.firstOrNull { it.id == currentId }
        }


    override suspend fun getAccount(): Result<AccountDomain> {
        return runCatching {
            accountApi.getAccount().toDomain()
        }
    }
    override suspend fun postAccount(
        accountDomain: AccountDomain
    ): Result<AccountDomain> {
        return runCatching {
            accountApi.createRoom(
                accountDto = accountDomain.toDto()
            ).toDomain()
        }
    }
    override suspend fun putAccount(
        accountDomain: AccountDomain
    ): Result<AccountDomain> {
        return runCatching {
            accountApi.putAccount(
                accountDto = accountDomain.toDto()
            ).toDomain()
        }
    }
    override suspend fun deleteAccount(
        accountDomain: AccountDomain
    ): Result<Unit> {
        return runCatching {
            accountApi.deleteAccount(
                accountDto = accountDomain.toDto()
            )
        }
    }
}