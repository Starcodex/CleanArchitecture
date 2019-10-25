package com.starcodex.cleanarchitecture.ui.movies.di

import androidx.lifecycle.ViewModel
import com.starcodex.cleanarchitecture.data.movies.repository.LocalMoviesSource
import com.starcodex.cleanarchitecture.data.movies.repository.MoviesRepository
import com.starcodex.cleanarchitecture.data.movies.repository.MoviesRepositoryImpl
import com.starcodex.cleanarchitecture.data.movies.repository.RemoteMoviesSource
import com.starcodex.cleanarchitecture.di.annotations.ViewModelKey
import com.starcodex.cleanarchitecture.ui.movies.detail.DetailMovieFragment
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListFragment
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListViewModel
import com.starcodex.cleanarchitexture.domain.movies.usecase.GetMoviesListUseCase
import com.starcodex.cleanarchitexture.domain.movies.usecase.GetMoviesListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = arrayOf(MoviesActivityDataModule::class))
abstract class MoviesActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MoviesListFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailMovieFragment(): DetailMovieFragment

    // Bind ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(MoviesListViewModel::class)
    abstract fun bindMoviesListViewModel(moviesViewModel: MoviesListViewModel): ViewModel

    // Bind UseCase
    @Binds
    abstract fun bindGetMoviesListUseCase(useCaseImpl: GetMoviesListUseCaseImpl): GetMoviesListUseCase

    // Bind MoviesRepository
    @Binds
    abstract fun bindMoviesRepository(repositoryImpl: MoviesRepositoryImpl): com.starcodex.cleanarchitexture.domain.movies.repository.MoviesRepository

    // Bind Repository
    @Binds
    abstract fun bindRemoteMoviesRepository(repository: MoviesRepository): RemoteMoviesSource

    @Binds
    abstract fun bindLocalMoviesRepository(repository: MoviesRepository): LocalMoviesSource


}