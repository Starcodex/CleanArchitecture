package com.starcodex.cleanarchitecture.testutil

import com.starcodex.cleanarchitecture.CAApplication
import com.starcodex.cleanarchitecture.mocks.di.DaggerAppComponentTest

class CAApplicationTest : CAApplication() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponentTest.builder().application(this).build().inject(this)
    }
}