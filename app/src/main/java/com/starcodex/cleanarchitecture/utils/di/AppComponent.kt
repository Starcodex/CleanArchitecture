package com.starcodex.cleanarchitecture.utils.di

import android.app.Application
import com.starcodex.cleanarchitecture.CAApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectBuilder::class,
    AppModule::class,
    FragmentBuildersModule::class,
    ViewModelModule::class,
    UseCaseModule::class,
    RepositoryModule::class])
interface AppComponent  {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: CAApplication)
}