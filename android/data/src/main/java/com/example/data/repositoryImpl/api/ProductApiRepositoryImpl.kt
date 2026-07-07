package com.example.data.repositoryImpl.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.api.ProductApi
import com.example.data.pagingSource.ProductPagingSource
import com.example.domain.model.ProductDomain
import com.example.domain.repository.api.ProductApiRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class ProductApiRepositoryImpl @Inject constructor(
    private val productApi: ProductApi
) : ProductApiRepository {

    override fun getProductList(): Flow<PagingData<ProductDomain>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 4,
                enablePlaceholders = false,
                initialLoadSize = 20
            ),

            pagingSourceFactory = { ProductPagingSource(productApi = productApi) }
        ).flow
    }
}
