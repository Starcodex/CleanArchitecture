package com.starcodex.cleanarchitecture.utils.di

import com.starcodex.cleanarchitecture.ui.movies.MoviesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidInjectBuilder {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun bindMainActivity(): MoviesActivity
}