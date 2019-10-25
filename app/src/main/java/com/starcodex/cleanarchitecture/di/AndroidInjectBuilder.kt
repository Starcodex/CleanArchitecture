package com.starcodex.cleanarchitecture.di

import com.starcodex.cleanarchitecture.ui.movies.MoviesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidInjectBuilder {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun bindMainActivity(): MoviesActivity
}