package com.starcodex.cleanarchitecture.domain.movies.usecase

import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

interface GetMoviesListUseCaseSource {

    fun executeListLocal(category: String, onComplete: (it: List<MovieItem>) -> Unit) : Disposable

    fun executeListRemote(category: String, onComplete: (it: List<MovieItem>) -> Unit) : Disposable

}