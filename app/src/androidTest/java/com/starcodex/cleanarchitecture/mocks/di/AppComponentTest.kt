package com.starcodex.cleanarchitecture.mocks.di

import android.app.Application
import com.starcodex.cleanarchitecture.testutil.CAApplicationTest
import com.starcodex.cleanarchitecture.utils.di.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectBuilder::class,
    AppModuleTest::class,
    FragmentBuildersModule::class,
    ViewModelModule::class,
    UseCaseModule::class,
    RepositoryModule::class])
interface AppComponentTest  {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponentTest
    }

    fun inject(app: CAApplicationTest)
}