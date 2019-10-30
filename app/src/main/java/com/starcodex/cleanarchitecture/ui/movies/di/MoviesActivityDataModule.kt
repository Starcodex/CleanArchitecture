package com.starcodex.cleanarchitecture.ui.movies.di

import com.starcodex.cleanarchitecture.data.AppDatabase
import com.starcodex.cleanarchitecture.data.movies.source.dao.CategoriesMoviesDao
import com.starcodex.cleanarchitecture.data.movies.source.dao.CategoryDao
import com.starcodex.cleanarchitecture.data.movies.source.dao.MovieDao
import com.starcodex.cleanarchitecture.data.movies.source.remote.MoviesListApiClient
import com.starcodex.cleanarchitecture.di.module.DataModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module(includes = arrayOf(DataModule::class))
class MoviesActivityDataModule {


    @Provides
    fun provideMoviesListApiClient(retrofit: Retrofit) = retrofit.create(MoviesListApiClient::class.java)

    @Provides
    fun provideMovieDao(db: AppDatabase): MovieDao {
        return db.movieDao()
    }

    @Provides
    fun provideCategoryDao(db: AppDatabase): CategoryDao {
        return db.categoryDao()
    }

    @Provides
    fun provideCategoriesMoviesDao(db: AppDatabase): CategoriesMoviesDao {
        return db.categoryMovieDao()
    }

}