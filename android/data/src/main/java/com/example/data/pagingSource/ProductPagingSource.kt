package com.example.data.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.api.ProductApi
import com.example.data.model.constant.PagingDirection
import com.example.data.mapper.toDomain
import com.example.domain.model.ProductDomain

class ProductPagingSource (
    private val productApi: ProductApi
) : PagingSource<Int, ProductDomain>() {
    override fun getRefreshKey(state: PagingState<Int, ProductDomain>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(anchorPosition = it)?.prevKey?.plus(other = 1)
                ?: state.closestPageToPosition(anchorPosition = it)?.nextKey?.minus(other = 1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductDomain> {
        val currentCursor = params.key

        val direction = when (params) {
            is LoadParams.Prepend -> PagingDirection.PREV.value
            is LoadParams.Append -> PagingDirection.NEXT.value
            is LoadParams.Refresh -> PagingDirection.NEXT.value
        }

        return try {
            val response = productApi.getProductList(
                cursor = currentCursor,
                size = params.loadSize,
                direction = direction
            ).toDomain()

            val products = response.productList

            LoadResult.Page(
                data = products,
                prevKey = response.prevCursor,
                nextKey = if (products.isEmpty()) null else response.nextCursor
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}