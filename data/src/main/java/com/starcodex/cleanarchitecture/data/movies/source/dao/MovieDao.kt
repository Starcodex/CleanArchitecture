package com.starcodex.cleanarchitecture.data.movies.source.dao

import androidx.room.*
import com.starcodex.cleanarchitecture.data.movies.source.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(mClassEntity: MovieEntity)
}