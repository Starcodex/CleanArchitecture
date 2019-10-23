package com.starcodex.cleanarchitecture.utils.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.starcodex.cleanarchitecture.ui.movies.list.MoviesListViewModel
import com.starcodex.cleanarchitecture.utils.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.mockito.Mock
import org.mockito.Mockito

@Module
abstract class ViewModelModuleTest : ViewModelModule()