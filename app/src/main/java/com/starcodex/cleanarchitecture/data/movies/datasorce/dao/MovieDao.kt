package com.starcodex.cleanarchitecture.data.movies.datasorce.dao

import androidx.room.*
import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(mClassEntity: MovieEntity)
}