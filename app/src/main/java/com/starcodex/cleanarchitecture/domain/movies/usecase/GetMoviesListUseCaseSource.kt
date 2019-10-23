package com.starcodex.cleanarchitecture.domain.movies.usecase

import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

interface GetMoviesListUseCaseSource {

    fun executeListLocal(category: String) : Observable<List<MovieItem>>?

    fun executeListRemote(category: String) : Observable<List<MovieItem>>?

}