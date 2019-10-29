package com.starcodex.cleanarchitecture.di.module

import android.app.Application
import androidx.room.Room
import com.starcodex.cleanarchitecture.BuildConfig.*
import com.starcodex.cleanarchitecture.data.AppDatabase
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

}