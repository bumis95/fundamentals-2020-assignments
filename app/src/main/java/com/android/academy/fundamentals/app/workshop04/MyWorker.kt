package com.android.academy.fundamentals.app.workshop04

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        for (second in 0..10) {
            Log.d("MyWorker", "Attempt to connect. Attempts: $second")
            Thread.sleep(1000)
            if (ConnectionChecker.isOnline()) {
                return Result.success()
            }
        }
        return Result.failure()
    }
}
