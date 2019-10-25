package com.starcodex.cleanarchitecture.data.movies.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.starcodex.cleanarchitecture.data.movies.source.entity.CategoryEntity

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: CategoryEntity)
}