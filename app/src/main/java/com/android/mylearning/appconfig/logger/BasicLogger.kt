package com.android.mylearning.appconfig.logger
import android.util.Log

 abstract class BasicLogger : MyLogger {
    override fun d(name: String, message: String) {
        Log.d(name, message)
    }

     override fun e(name: String, error: String) {
         Log.e(name, error)
     }

     override fun e(name: String, error: String, throwable: Throwable) {
         Log.e(name,error,throwable)
     }
 }