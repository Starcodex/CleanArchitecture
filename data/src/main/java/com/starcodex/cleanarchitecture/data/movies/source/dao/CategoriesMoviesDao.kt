package com.starcodex.cleanarchitecture.data.movies.source.dao

import androidx.room.*
import com.starcodex.cleanarchitecture.data.movies.source.entity.CategoryMovieEntity
import com.starcodex.cleanarchitecture.data.movies.source.entity.MovieEntity
import io.reactivex.Observable

@Dao
interface CategoriesMoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categoryMovie: CategoryMovieEntity)

    @Query(" SELECT MOVIE.* FROM MOVIE INNER JOIN CATEGORIES_MOVIES ON MOVIE.id = CATEGORIES_MOVIES.movie_id WHERE CATEGORIES_MOVIES.category_name = :category ")
    fun getMoviesByCategory(category: String): Observable<List<MovieEntity>>

}