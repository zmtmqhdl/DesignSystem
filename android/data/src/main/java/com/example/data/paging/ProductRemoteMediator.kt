package com.example.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.data.api.ProductApi
import com.example.data.database.CommonDatabase
import com.example.data.mapper.toEntity
import com.example.data.model.enum.PagingDirection
import com.example.data.model.entity.ProductEntity
import com.example.data.model.entity.key.DatabaseNames
import com.example.domain.model.domain.PagingKeyDomain
import java.io.IOException
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class ProductRemoteMediator(
    private val commonDatabase: CommonDatabase,
    private val productApi: ProductApi,
) : RemoteMediator<Int, ProductEntity>() {

    private val productDao = commonDatabase.productDao()
    private val pagingKeyDao = commonDatabase.pagingKeyDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ProductEntity>
    ): MediatorResult {
        return try {
            val pagingKeyName = DatabaseNames.PRODUCT
            val pagingKey = pagingKeyDao.getPagingKey(pagingKeyName)

            val (cursor, direction) = when (loadType) {
                LoadType.REFRESH -> {
                    null to PagingDirection.PREVIOUS
                }
                LoadType.PREPEND -> {
                    return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                }
                LoadType.APPEND -> {
                    val prevCursor = pagingKey?.previousCursor
                        ?: return MediatorResult.Success(endOfPaginationReached = true)

                    prevCursor to PagingDirection.PREVIOUS
                }
            }

            val response = productApi.getProducts(
                cursor = cursor,
                direction = direction.value,
                size = state.config.pageSize
            )
            val products = response.products.map { it.toEntity() }

            commonDatabase.withTransaction {
                when (loadType) {
                    LoadType.REFRESH -> {
                        pagingKeyDao.insertPagingKey(
                            pagingKey = PagingKeyDomain(
                                name = pagingKeyName,
                                nextCursor = response.nextCursor,
                                previousCursor = response.previousCursor
                            ).toEntity()
                        )
                        productDao.clearAll()
                        productDao.insertProducts(products)
                    }
                    LoadType.APPEND -> {
                        pagingKeyDao.updatePagingKey(
                            pagingKey = PagingKeyDomain(
                                name = pagingKeyName,
                                nextCursor = response.nextCursor,
                                previousCursor = response.previousCursor
                            ).toEntity()
                        )
                        productDao.insertProducts(products)
                    }
                    LoadType.PREPEND -> {
                    }
                }
            }

            val endOfPaginationReached = when (loadType) {
                LoadType.APPEND,
                LoadType.REFRESH -> products.isEmpty()
            }

            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}