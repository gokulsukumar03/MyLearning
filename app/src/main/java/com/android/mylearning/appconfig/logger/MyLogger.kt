package com.android.mylearning.appconfig.logger
interface MyLogger{
    fun d(name : String, message : String)
    fun e(name : String, error : String)
    fun e(name : String, error : String, throwable: Throwable)
}