package com.android.mylearning.workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.android.mylearning.database.AppDatabase
import com.android.mylearning.database.entities.Plant

class OneTimeWorker(context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        return try {
            val plantList = ArrayList<Plant>()
            plantList.add(Plant("1", "Mango", "Mango Milk Shake", "nil"))
            val database = AppDatabase.getInstance(applicationContext)
            database.plantDoa().insertAll(plantList)
            Result.success()
        } catch (error: Throwable) {
            Result.failure()
        }
    }

}