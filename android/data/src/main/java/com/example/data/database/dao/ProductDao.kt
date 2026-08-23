package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.domain.model.domain.ProductDomain
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_database")
    fun getProductList(): Flow<List<ProductDomain>>
}