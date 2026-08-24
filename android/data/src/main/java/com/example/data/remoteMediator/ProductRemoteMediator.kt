package com.example.data.remoteMediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.data.api.ProductApi
import com.example.data.database.dao.ProductDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.data.model.constant.PagingDirection
import com.example.data.model.entity.ProductEntity

@OptIn(ExperimentalPagingApi::class)
class ProductRemoteMediator(
    private val productApi: ProductApi,
    private val productDao: ProductDao
) : RemoteMediator<Int, ProductEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ProductEntity>
    ): MediatorResult {
        return try {
            // 1. Paging 상태(LoadType)에 따라 서버로 보낼 커서(Cursor) 계산
            val cursor: Int? = when (loadType) {
                LoadType.REFRESH -> null // 처음 로딩 시 첫 페이지(null) 요청
                LoadType.PREPEND -> {
                    // 이전 페이지 로딩은 안 쓰므로 바로 종료
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                LoadType.APPEND -> {
                    // DB에 저장된 마지막 아이템을 가져와서 그 아이템의 ID/커서 값 추출
                    val lastItem = state.lastItemOrNull() ?: return MediatorResult.Success(endOfPaginationReached = true)
                    lastItem.id.toInt() // 예시: DB에 있는 마지막 상품의 ID/커서
                }
            }

            val direction = when (loadType) {
                LoadType.PREPEND -> PagingDirection.PREV.value
                else -> PagingDirection.NEXT.value
            }

            // 2. 서버 API 호출
            val response = productApi.getProductList(
                cursor = cursor,
                direction = direction,
                size = state.config.pageSize
            ).toDomain()

            val products = response.productList

            // 3. ⭐️ 핵심: 서버에서 받아온 데이터를 UI에 바로 안 주고 DB에 저장!
            // 만약 사용자가 '새로고침(REFRESH)'을 한 상황이라면 기존 DB를 지우고 새로 채움
            if (loadType == LoadType.REFRESH) {
                productDao.clearAll()
            }
            // 받아온 데이터를 Entity로 변환해서 DB에 배치 저장
            productDao.insertProducts(products.map { it.toEntity() })

            // 4. 서버에서 더 이상 가져올 상품이 없는지 판단하여 반환
            val endOfPaginationReached = products.isEmpty()
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}