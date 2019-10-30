package com.starcodex.cleanarchitecture.ui.movies.di

import androidx.lifecycle.ViewModel
import com.starcodex.cleanarchitexture.domain.movies.repository.MoviesRepository
import com.starcodex.cleanarchitecture.data.movies.repository.MoviesRepositoryImpl
import com.starcodex.cleanarchitecture.di.annotations.ViewModelKey
import com.starcodex.cleanarchitecture.ui.movies.FragmentActivityInteraction
import com.starcodex.cleanarchitecture.ui.movies.MoviesActivity
import com.starcodex.cleanarchitecture.ui.movies.detail.DetailMovieFragment
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListFragment
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListViewModelImpl
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

    // Bind Activity Interactor
    @Binds
    abstract fun bindMoviesActivityInteractor(activity: MoviesActivity) : FragmentActivityInteraction

    // Bind ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(MoviesListViewModelImpl::class)
    abstract fun bindMoviesListViewModel(moviesViewModel: MoviesListViewModelImpl): ViewModel

    // Bind UseCase
    @Binds
    abstract fun bindGetMoviesListUseCase(useCaseImpl: GetMoviesListUseCaseImpl): GetMoviesListUseCase

    // Bind MoviesRepository
    @Binds
    abstract fun bindMoviesRepository(repositoryImpl: MoviesRepositoryImpl): MoviesRepository


}