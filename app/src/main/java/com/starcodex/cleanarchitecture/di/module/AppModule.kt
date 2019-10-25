package com.starcodex.cleanarchitecture.di.module

import com.starcodex.cleanarchitecture.commons.app.ExecutionThreads
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module(includes = arrayOf(DataModule::class, ViewModelModule::class))
class AppModule {


    @Provides
    fun provideExecutionThreads(): ExecutionThreads {
        return object : ExecutionThreads {
            override fun ui(): Scheduler = AndroidSchedulers.mainThread()
            override fun io(): Scheduler = Schedulers.io()
        }
    }


}
