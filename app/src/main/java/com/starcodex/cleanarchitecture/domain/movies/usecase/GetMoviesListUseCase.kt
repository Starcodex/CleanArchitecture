package com.starcodex.cleanarchitecture.domain.movies.usecase

import com.starcodex.cleanarchitecture.data.movies.source.entity.mapToDomain
import com.starcodex.cleanarchitecture.data.movies.repository.LocalMoviesSource
import com.starcodex.cleanarchitecture.data.movies.repository.RemoteMoviesSource
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.commons.app.ExecutionThreads
import io.reactivex.disposables.Disposable
import javax.inject.Inject
class GetMoviesListUseCase
@Inject constructor(
    private val localMoviesRepository: LocalMoviesSource,
    private val remoteMoviesRepository: RemoteMoviesSource,
    var executionThreads: ExecutionThreads
)
{

    fun executeListLocal(category: String, onNext:(it: List<MovieItem>) -> Unit): Disposable {
        return localMoviesRepository.getLocalMoviesList(category).map { it.map { t-> t.mapToDomain() } }
            .observeOn(executionThreads.ui())
            .subscribe{
                if(it.isEmpty())
                    executeListRemote(category,onNext)
                else
                    onNext(it)
            }
    }

    fun executeListRemote(category: String, onNext:(it: List<MovieItem>) -> Unit): Disposable{
        return remoteMoviesRepository.getRemoteMoviesList(category).map { it.map { t-> t.mapToDomain() } }
            .observeOn(executionThreads.ui())
            .subscribe{
                onNext(it)
            }
    }

}
