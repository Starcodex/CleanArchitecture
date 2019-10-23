package com.starcodex.cleanarchitecture.data.movies.repository

import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.MovieEntity
import io.reactivex.Maybe
import io.reactivex.Observable

interface LocalMoviesSource {
    fun getLocalMoviesList(category: String) : Maybe<List<MovieEntity>>
}