package com.starcodex.cleanarchitecture.data.movies.repository

import com.starcodex.cleanarchitecture.data.movies.source.entity.MovieEntity
import io.reactivex.Observable

interface LocalMoviesSource {
    fun getLocalMoviesList(category: String) : Observable<List<MovieEntity>>
}