package com.starcodex.cleanarchitecture.utils.di

import com.starcodex.cleanarchitecture.ui.movies.MoviesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidInjectBuilderTest {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MoviesActivity
}