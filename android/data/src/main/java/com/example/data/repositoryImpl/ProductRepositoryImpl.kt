package com.example.data.repositoryImpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.api.ProductApi
import com.example.data.database.dao.ProductDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.data.paging.ProductRemoteMediator
import com.example.domain.model.domain.ProductDomain
import com.example.domain.repository.ProductRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalPagingApi::class)
class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
    private val productApi: ProductApi
) : ProductRepository {

    override fun getProducts(): Flow<PagingData<ProductDomain>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            remoteMediator = ProductRemoteMediator(
                productApi = productApi,
                productDao = productDao
            ),
            pagingSourceFactory = { productDao.getProductList() }
        ).flow
            .map { pagingData ->
                pagingData.map { entity -> entity.toDomain() }
            }
    }

    override suspend fun insertProducts(products: List<ProductDomain>) {
        productDao.insertProducts(products.map { it.toEntity() })
    }
    override suspend fun updateProduct(product: ProductDomain) {
        productDao.updateProduct(product.toEntity())
    }
    override suspend fun updateProducts(products: List<ProductDomain>) {
        productDao.updateProducts(products.map { it.toEntity() })
    }
    override suspend fun deleteAllProducts() {
        productDao.clearAll()
    }
}