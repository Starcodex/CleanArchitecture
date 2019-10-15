package com.starcodex.cleanarchitecture.utils.di

import android.app.Application
import androidx.room.Room
import com.starcodex.cleanarchitecture.BuildConfig.*
import com.starcodex.cleanarchitecture.data.AppDatabase
import com.starcodex.cleanarchitecture.data.movies.datasorce.dao.CategoriesMoviesDao
import com.starcodex.cleanarchitecture.data.movies.datasorce.dao.CategoryDao
import com.starcodex.cleanarchitecture.data.movies.datasorce.dao.MovieDao
import com.starcodex.cleanarchitecture.utils.di.network.ApiModule
import dagger.Module
import dagger.Provides


@Module(includes = arrayOf(ApiModule::class))
class DataModule {

    @Provides
    fun providesAppDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

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