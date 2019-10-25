package com.starcodex.cleanarchitecture.commons.app

import io.reactivex.Scheduler

interface ExecutionThreads {
    fun io(): Scheduler
    fun ui(): Scheduler
}