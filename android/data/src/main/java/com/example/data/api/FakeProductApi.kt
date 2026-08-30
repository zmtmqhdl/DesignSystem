package com.example.data.api

import com.example.data.model.dto.ProductDto
import com.example.data.model.dto.ProductsDto
import kotlinx.coroutines.delay
import javax.inject.Inject

class FakeProductApi @Inject constructor() : ProductApi {

    // 메모리에 생성해둔 100개의 가짜 상품 데이터
    private val fakeProducts = List(5000) { index ->
        ProductDto(
            id = (index + 1).toLong(),
            name = "테스트 상품 ${index + 1}",
            price = (index + 1) * 10000L,
            imageUrl = ""
        )
    }

    override suspend fun getProducts(
        cursor: Long?,
        direction: String?,
        size: Int?
    ): ProductsDto {
        delay(1000)

        val pageSize = size ?: 20
        val currentCursorId = cursor ?: 0L

        // 1. currentCursorId 보다 ID가 큰 상품들만 추출 (20 넘기면 21부터)
        val filtered = fakeProducts.filter { it.id > currentCursorId }

        // 2. 요청된 pageSize(20개) 만큼 가져옴 (21 ~ 40)
        val pageItems = filtered.take(pageSize)

        // 3. 이번에 가져온 리스트의 '마지막 ID' (예: 40)
        val lastItemId = pageItems.lastOrNull()?.id

        // 4. filtered 개수가 pageSize보다 크면 뒤에 더 불러올 데이터가 있다는 뜻
        val hasMore = filtered.size > pageSize
        val nextCursorValue = if (hasMore) lastItemId else null

        return ProductsDto(
            products = pageItems,
            nextCursor = nextCursorValue,
            previousCursor = nextCursorValue, // 다음 요청 때 cursor=40 으로 보낼 수 있도록 세팅
            updatedProducts = emptyList()
        )
    }
}