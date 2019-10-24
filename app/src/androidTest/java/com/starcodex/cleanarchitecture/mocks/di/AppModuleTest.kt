package com.starcodex.cleanarchitecture.mocks.di

import com.starcodex.cleanarchitecture.utils.commons.ExecutionThreads
import com.starcodex.cleanarchitecture.utils.di.DataModule
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module(includes = arrayOf(DataModule::class))
class AppModuleTest {

    @Provides
    fun provideExecutionThreads(): ExecutionThreads {
        return object : ExecutionThreads {
            override fun ui() = AndroidSchedulers.mainThread()
            override fun io() = Schedulers.io()
        }
    }
}