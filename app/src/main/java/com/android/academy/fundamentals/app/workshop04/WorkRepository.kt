package com.android.academy.fundamentals.app.workshop04

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import java.util.concurrent.TimeUnit

class WorkRepository {

    val simpleRequest = OneTimeWorkRequest.Builder(MyWorker::class.java).build()

    val delayedRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
        .setInitialDelay(10L, TimeUnit.SECONDS).build()

    private val constraints =
        Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
    val constrainedRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
        .setConstraints(constraints)
        .build()
}