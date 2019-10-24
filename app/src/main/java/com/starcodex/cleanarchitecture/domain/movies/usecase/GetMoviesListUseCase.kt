package com.starcodex.cleanarchitecture.domain.movies.usecase

import com.starcodex.cleanarchitecture.data.movies.datasorce.entity.mapToDomain
import com.starcodex.cleanarchitecture.data.movies.repository.LocalMoviesSource
import com.starcodex.cleanarchitecture.data.movies.repository.RemoteMoviesSource
import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.utils.commons.ExecutionThreads
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject
class GetMoviesListUseCase
@Inject constructor(
    var localMoviesRepository: LocalMoviesSource,
    var remoteMoviesRepository: RemoteMoviesSource,
    var executionThreads: ExecutionThreads) : GetMoviesListUseCaseSource
{

    override fun executeListLocal(category: String, onComplete: (it: List<MovieItem>) -> Unit): Disposable {
        return localMoviesRepository.getLocalMoviesList(category).map { it.map { t-> t.mapToDomain() } }
            .observeOn(executionThreads.io())
            .doOnEvent{ value, _ ->
                if (value.isEmpty()){
                    executeListRemote(category, onComplete)
                }
            }
            .subscribe{
                onComplete(it)
            }
    }

    override fun executeListRemote(category: String, onComplete: (it: List<MovieItem>) -> Unit): Disposable{
        return remoteMoviesRepository.getRemoteMoviesList(category).map { it.map { t-> t.mapToDomain() } }
            .observeOn(executionThreads.io())
            .subscribe{
                onComplete(it)
            }
    }

}
