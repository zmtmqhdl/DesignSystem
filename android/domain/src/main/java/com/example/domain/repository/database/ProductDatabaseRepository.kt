package com.example.domain.repository.database

import com.example.domain.model.domain.ProductDomain
import kotlinx.coroutines.flow.Flow

interface ProductDatabaseRepository {
    val products: Flow<List<ProductDomain>>

    suspend fun insertProducts(products: List<ProductDomain>)

    suspend fun updateProduct(product: ProductDomain)
    suspend fun updateProducts(products: List<ProductDomain>)
}