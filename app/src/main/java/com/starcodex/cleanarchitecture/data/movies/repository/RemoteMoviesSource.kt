package com.starcodex.cleanarchitecture.data.movies.repository

import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.MovieEntity
import io.reactivex.Observable

interface RemoteMoviesSource {
    fun getRemoteMoviesList(category: String) : Observable<List<MovieEntity>>
}