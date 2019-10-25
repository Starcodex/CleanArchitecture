package com.starcodex.cleanarchitecture.di.component

import android.app.Application
import com.starcodex.cleanarchitecture.CAApplication
import com.starcodex.cleanarchitecture.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuildersModule::class,
    AppModule::class])
interface AppComponent  {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: CAApplication)
}