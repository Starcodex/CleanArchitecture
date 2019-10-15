package com.starcodex.cleanarchitecture.utils.di

import android.app.Application
import com.starcodex.cleanarchitecture.CAApplicationTest
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectBuilderTest::class,
    AppModuleTest::class,
    FragmentBuildersModuleTest::class,
    ViewModelModuleTest::class,
    RepositoryModuleTest::class
])
interface AppComponentTest: AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponentTest
    }
    fun inject(application: CAApplicationTest)
}