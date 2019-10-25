package com.starcodex.cleanarchitecture.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.starcodex.cleanarchitecture.data.movies.source.dao.CategoriesMoviesDao
import com.starcodex.cleanarchitecture.data.movies.source.dao.CategoryDao
import com.starcodex.cleanarchitecture.data.movies.source.dao.MovieDao
import com.starcodex.cleanarchitecture.data.movies.source.entity.CategoryEntity
import com.starcodex.cleanarchitecture.data.movies.source.entity.CategoryMovieEntity
import com.starcodex.cleanarchitecture.data.movies.source.entity.MovieEntity


@Database(entities = arrayOf(
    MovieEntity::class,
    CategoryEntity::class,
    CategoryMovieEntity::class
), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun categoryDao(): CategoryDao
    abstract fun categoryMovieDao(): CategoriesMoviesDao
}