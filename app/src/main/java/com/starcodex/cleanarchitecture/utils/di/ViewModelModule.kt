package com.starcodex.cleanarchitecture.utils.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListViewModel
import com.starcodex.cleanarchitecture.utils.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(MoviesListViewModel::class)
    abstract fun bindMoviesListViewModel(moviesViewModel: MoviesListViewModel): ViewModel


}