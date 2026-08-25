package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.domain.ProductDomain
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<PagingData<ProductDomain>>

    suspend fun insertProducts(products: List<ProductDomain>)
    suspend fun updateProduct(product: ProductDomain)
    suspend fun updateProducts(products: List<ProductDomain>)
    suspend fun clearProducts()
}