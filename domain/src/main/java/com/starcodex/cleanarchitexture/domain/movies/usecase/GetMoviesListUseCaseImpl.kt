package com.starcodex.cleanarchitexture.domain.movies.usecase

import com.starcodex.cleanarchitecture.commons.app.ExecutionThreads
import com.starcodex.cleanarchitexture.domain.movies.repository.MoviesRepository
import javax.inject.Inject

class GetMoviesListUseCaseImpl
@Inject constructor(
    private val moviesRepository: MoviesRepository,
    var executionThreads: ExecutionThreads
): GetMoviesListUseCase {
}