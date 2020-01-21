package com.android.mylearning.appconfig.logger

class SDKLogger : BasicLogger() {
        @Volatile internal var instance: SDKLogger?=null
        fun getInstance(): SDKLogger {
            if (instance == null) {
                synchronized(SDKLogger::class.java) {
                    if (instance == null) {
                        instance = SDKLogger()
                    }
                }
            }
            return instance!!
        }
    }