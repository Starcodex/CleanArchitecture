package com.starcodex.cleanarchitecture.data.movies.repository

import com.starcodex.cleanarchitecture.data.movies.source.dao.CategoriesMoviesDao
import com.starcodex.cleanarchitecture.data.movies.source.dao.CategoryDao
import com.starcodex.cleanarchitecture.data.movies.source.dao.MovieDao
import com.starcodex.cleanarchitecture.data.movies.source.remote.MoviesListApiClient
import com.starcodex.cleanarchitexture.domain.movies.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl
@Inject constructor(
    private val moviesListApiClient: MoviesListApiClient,
    private val moviesLocalDao: MovieDao,
    private val categoriesMoviesDao: CategoriesMoviesDao,
    private val categoryDao: CategoryDao
): MoviesRepository {
}