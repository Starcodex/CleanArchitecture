package com.starcodex.cleanarchitecture.testutil

import android.app.Instrumentation
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class TestApplicationRunner: AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?)
            = Instrumentation.newApplication(CAApplicationTest::class.java, context)
}