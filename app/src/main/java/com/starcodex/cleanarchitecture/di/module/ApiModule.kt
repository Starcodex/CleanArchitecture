package com.starcodex.cleanarchitecture.di.module

import com.google.gson.GsonBuilder
import com.starcodex.cleanarchitecture.commons.BuildConfig.DOMAIN
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    internal fun provideRetrofit(): Retrofit {
        val gson = GsonBuilder().create()
        val gsonConverterFactory = GsonConverterFactory.create(gson)

        return Retrofit.Builder()
            .baseUrl("http://$DOMAIN/")
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }


}