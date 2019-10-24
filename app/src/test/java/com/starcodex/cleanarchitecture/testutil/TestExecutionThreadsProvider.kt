package com.starcodex.cleanarchitecture.testutil

import com.starcodex.cleanarchitecture.utils.commons.ExecutionThreads
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class TestExecutionThreadsProvider : ExecutionThreads {
    override fun ui() = AndroidSchedulers.mainThread()
    override fun io() = Schedulers.io()
}