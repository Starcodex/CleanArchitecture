package com.starcodex.cleanarchitecture.data.movies.repository

import com.starcodex.cleanarchitecture.data.movies.source.dao.CategoriesMoviesDao
import com.starcodex.cleanarchitecture.data.movies.source.dao.CategoryDao
import com.starcodex.cleanarchitecture.data.movies.source.dao.MovieDao
import com.starcodex.cleanarchitecture.data.movies.source.entity.CategoryEntity
import com.starcodex.cleanarchitecture.data.movies.source.entity.CategoryMovieEntity
import com.starcodex.cleanarchitecture.data.movies.source.entity.MovieEntity
import com.starcodex.cleanarchitecture.data.movies.source.remote.MoviesListApiClient
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
        categoryDao.insertCategory(
            CategoryEntity(
                category
            )
        )
        return moviesListApiClient.getMoviesByCategory(category).map {
            it.results.map {
                moviesLocalDao.insertMovie(it)
                categoriesMoviesDao.insert(
                    CategoryMovieEntity(
                        category,
                        it.id!!
                    )
                )
            }
            it.results
        }
    }
}













