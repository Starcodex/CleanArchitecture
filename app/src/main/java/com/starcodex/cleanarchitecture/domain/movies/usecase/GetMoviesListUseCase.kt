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
    private val localMoviesRepository: LocalMoviesSource,
    private val remoteMoviesRepository: RemoteMoviesSource,
    var executionThreads: ExecutionThreads) : GetMoviesListUseCaseSource
{

    override fun executeListLocal(category: String): Observable<List<MovieItem>>? {
        return localMoviesRepository.getLocalMoviesList(category).map { it.map { t-> t.mapToDomain() } }
            .observeOn(executionThreads.io())
            .doOnEvent{ value, _ ->
                if (value == null){
                    executeListRemote(category)
                }
            }
            .toObservable()
    }

    override fun executeListRemote(category: String): Observable<List<MovieItem>>?{
        return remoteMoviesRepository.getRemoteMoviesList(category).map { it.map { t-> t.mapToDomain() } }
            .observeOn(executionThreads.io())
    }

}
