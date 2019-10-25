package com.starcodex.cleanarchitecture.di.module

import com.starcodex.cleanarchitecture.ui.movies.MoviesActivity
import com.starcodex.cleanarchitecture.ui.movies.di.MoviesActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [MoviesActivityModule::class])
    abstract fun bindMainActivity(): MoviesActivity

}