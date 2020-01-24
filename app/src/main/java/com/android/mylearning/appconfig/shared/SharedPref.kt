package com.android.mylearning.appconfig.shared

interface SharedPref{
    fun save(key : String, value : String)
    fun save(key : String, value : Int)
    fun save(key : String, value : Long)
    fun save(key: String, value: Boolean)
    fun getString(key: String) : String
    fun getInt(key: String) : Int
    fun getBoolean(key: String) : Boolean
    fun getLong(key: String) : Long

}