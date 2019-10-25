package com.starcodex.cleanarchitecture.di

import com.starcodex.cleanarchitecture.data.movies.repository.LocalMoviesSource
import com.starcodex.cleanarchitecture.data.movies.repository.MoviesRepository
import com.starcodex.cleanarchitecture.data.movies.repository.RemoteMoviesSource
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRemoteMoviesRepository(repository: MoviesRepository): RemoteMoviesSource

    @Binds
    abstract fun bindLocalMoviesRepository(repository: MoviesRepository): LocalMoviesSource
}