package com.android.mylearning.workmanager

import android.content.Context
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class PeriodicTimeWorker(context: Context, workerParams: WorkerParameters) : Worker(context,
    workerParams){
    override fun doWork(): Result {
        return try{
            Log.d("print" , "Periodic TimeWorker")
            Result.success()
        }catch (throwable :Throwable){
            Result.failure()
        }
        finally {

        }
    }

}