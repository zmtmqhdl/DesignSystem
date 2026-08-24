package com.example.data.repositoryImpl.database

import com.example.data.database.dao.ProductDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.model.domain.ProductDomain
import com.example.domain.repository.database.ProductDatabaseRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductDatabaseRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductDatabaseRepository {
    override val products: Flow<List<ProductDomain>> =
        productDao.getProductList()
            .map { entities ->
                entities.map { entity ->
                    entity.toDomain()
                }
            }

    override suspend fun insertProducts(products: List<ProductDomain>) {
        val entities = products.map { it.toEntity() }
        productDao.insertProducts(entities)
    }

    override suspend fun updateProduct(product: ProductDomain) {
        productDao.updateProduct(product.toEntity())
    }

    override suspend fun updateProducts(products: List<ProductDomain>) {
        val entities = products.map { it.toEntity() }
        productDao.updateProducts(entities)
    }
}