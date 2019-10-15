package com.starcodex.cleanarchitecture

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.starcodex.cleanarchitecture.utils.di.DaggerAppComponentTest
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class CAApplicationTest : CAApplication() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponentTest.builder().application(this).build().inject(this)
    }
}