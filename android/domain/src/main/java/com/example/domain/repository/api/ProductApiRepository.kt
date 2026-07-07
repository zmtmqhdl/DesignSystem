package com.example.domain.repository.api

import androidx.paging.PagingData
import com.example.domain.model.ProductDomain
import kotlinx.coroutines.flow.Flow

interface ProductApiRepository {
    fun getProductList(): Flow<PagingData<ProductDomain>>
}
