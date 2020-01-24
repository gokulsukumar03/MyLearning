package com.android.mylearning.appconfig.shared

import android.content.Context
 open class LearningSharedPref(context : Context) : SharedPref{

    private val mSharedPref = context.getSharedPreferences("my_learning", Context.MODE_PRIVATE)

    override fun save(key: String, value: String) {
        mSharedPref.edit().putString(key,value).apply()
    }

    override fun save(key: String, value: Int) {
        mSharedPref.edit().putInt(key,value).apply()
    }

    override fun save(key: String, value: Long) {
        mSharedPref.edit().putLong(key,value).apply()
    }

    override fun save(key: String, value: Boolean) {
       mSharedPref.edit().putBoolean(key,value).apply()
    }

     override fun getString(key: String): String {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun getInt(key: String): Int {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun getBoolean(key: String): Boolean {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun getLong(key: String): Long {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }
 }