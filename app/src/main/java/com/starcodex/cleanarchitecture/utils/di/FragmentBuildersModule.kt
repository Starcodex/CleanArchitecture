package com.starcodex.cleanarchitecture.utils.di

import com.starcodex.cleanarchitecture.ui.movies.detail.DetailMovieFragment
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MoviesListFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailMovieFragment(): DetailMovieFragment
}