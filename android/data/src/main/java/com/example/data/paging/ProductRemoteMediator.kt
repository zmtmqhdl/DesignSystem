package com.example.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.data.api.ProductApi
import com.example.data.database.dao.ProductDao
import com.example.data.mapper.toEntity
import com.example.data.model.constant.PagingDirection
import com.example.data.model.entity.ProductEntity
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class ProductRemoteMediator(
    private val productApi: ProductApi,
    private val productDao: ProductDao
) : RemoteMediator<Int, ProductEntity>() {

    private var topCursor: Int? = null
    private var bottomCursor: Int? = null

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ProductEntity>
    ): MediatorResult {
        return try {
            val direction = when (loadType) {
                LoadType.REFRESH -> {
                    topCursor = null
                    bottomCursor = null
                    PagingDirection.NEXT
                }
                // 손가락 아래로 (위쪽/최신 스크롤)
                LoadType.PREPEND -> {
//                    state.firstItemOrNull()
//                        ?: return MediatorResult.Success(endOfPaginationReached = true)
//                    PagingDirection.NEXT

                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                // 손가락 위로 (아래쪽/과거 스크롤)
                LoadType.APPEND -> {
                    state.lastItemOrNull()
                        ?: return MediatorResult.Success(endOfPaginationReached = true)
                    PagingDirection.PREVIOUS
                }
            }

            val response = productApi.getProducts(
                cursor = if (direction == PagingDirection.NEXT) topCursor else bottomCursor,
                direction = direction.value,
                size = state.config.pageSize
            )
            val products = response.products.map { it.toEntity() }
            when (loadType) {
                LoadType.REFRESH -> {
                    productDao.clearAll()
                    topCursor = response.topCursor
                    bottomCursor = response.bottomCursor
                }
//                LoadType.PREPEND -> {
//                    topCursor = response.topCursor
//                }
                LoadType.APPEND -> {
                    bottomCursor = response.bottomCursor
                }
            }

            productDao.insertProducts(products)
            val endOfPaginationReached = when (loadType) {
//                LoadType.PREPEND -> true
                LoadType.APPEND -> products.isEmpty()
                LoadType.REFRESH -> false
            }

            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        }
    }
}