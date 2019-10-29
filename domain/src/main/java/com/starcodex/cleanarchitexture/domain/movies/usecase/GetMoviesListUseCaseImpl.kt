package com.starcodex.cleanarchitexture.domain.movies.usecase

import com.starcodex.cleanarchitecture.commons.app.ExecutionThreads
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitexture.domain.movies.repository.MoviesRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetMoviesListUseCaseImpl
@Inject constructor(
    private val moviesRepository: MoviesRepository,
    var executionThreads: ExecutionThreads
): GetMoviesListUseCase {
    override fun getMoviesList(category: String): Observable<List<MovieItem>> {
        return moviesRepository.retrieveMoviesList(category)
            .observeOn(executionThreads.io())
    }
}