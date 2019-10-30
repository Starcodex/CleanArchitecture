package com.starcodex.cleanarchitexture.domain.movies.repository

import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem
import io.reactivex.Observable

interface MoviesRepository {
    fun retrieveMoviesList(category : String) : Observable<List<MovieItem>>
}