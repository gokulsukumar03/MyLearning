package com.android.mylearning.appconfig.logger
import android.util.Log

 abstract class BasicLogger : MyLogger {
    override fun d(name: String, message: String) {
        Log.d(name, message)
    }
}