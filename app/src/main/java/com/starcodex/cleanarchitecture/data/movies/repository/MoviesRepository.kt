package com.starcodex.cleanarchitecture.data.movies.repository

import android.util.Log
import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.mapToDomain
import com.starcodex.cleanarchitecture.data.movies.datasorce.dao.CategoriesMoviesDao
import com.starcodex.cleanarchitecture.data.movies.datasorce.dao.CategoryDao
import com.starcodex.cleanarchitecture.data.movies.datasorce.dao.MovieDao
import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.CategoryEntity
import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.CategoryMovieEntity
import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.MovieEntity
import com.starcodex.cleanarchitecture.data.movies.datasorce.remote.MoviesListApiClient
import io.reactivex.Observable
import javax.inject.Inject

class MoviesRepository
@Inject constructor(
    private val moviesListApiClient: MoviesListApiClient,
    private val moviesLocalDao: MovieDao,
    private val categoriesMoviesDao: CategoriesMoviesDao,
    private val categoryDao: CategoryDao
): RemoteMoviesSource, LocalMoviesSource {

    override fun getLocalMoviesList(category: String): Observable<List<MovieEntity>> {
        return categoriesMoviesDao.getMoviesByCategory(category)
    }


    override fun getRemoteMoviesList(category: String): Observable<List<MovieEntity>> {
        categoryDao.insertCategory(CategoryEntity(category))
        return moviesListApiClient.getMoviesByCategory(category).map {
            it.results.map {
                moviesLocalDao.insertMovie(it)
                categoriesMoviesDao.insert(CategoryMovieEntity(category, it.id!!))
            }
            it.results
        }
    }
}













