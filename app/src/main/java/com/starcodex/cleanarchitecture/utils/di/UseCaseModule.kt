package com.starcodex.cleanarchitecture.utils.di

import com.starcodex.cleanarchitecture.domain.movies.usecase.GetMoviesListUseCase
import com.starcodex.cleanarchitecture.domain.movies.usecase.GetMoviesListUseCaseSource
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindMoviesListUseCase(repository: GetMoviesListUseCase): GetMoviesListUseCaseSource

}