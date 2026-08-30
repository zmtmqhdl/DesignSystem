package com.example.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.model.entity.ProductEntity
import com.example.data.model.entity.key.DatabaseNames

@Dao
interface ProductDao {
    @Query("SELECT * FROM ${DatabaseNames.PRODUCT}")
    fun getProductList(): PagingSource<Int, ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Update
    suspend fun updateProduct(product: ProductEntity)
    @Update
    suspend fun updateProducts(products: List<ProductEntity>)

    @Query("DELETE FROM ${DatabaseNames.PRODUCT}")
    suspend fun clearAll()
}