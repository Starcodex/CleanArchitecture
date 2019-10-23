package com.starcodex.cleanarchitecture

import androidx.test.InstrumentationRegistry
import com.starcodex.cleanarchitecture.utils.di.AppComponentTest
import com.starcodex.cleanarchitecture.utils.di.AppModuleTest
import it.cosenonjaviste.daggermock.DaggerMock

fun espressoDaggerMockRule() = DaggerMock.rule<AppComponentTest>(AppModuleTest()) {
    set { component -> component.inject(app) }
}

val app: CAApplicationTest
    get() = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as CAApplicationTest