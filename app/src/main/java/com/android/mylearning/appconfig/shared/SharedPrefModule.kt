package com.android.mylearning.appconfig.shared

import android.content.Context
import android.content.SharedPreferences
 class SharedPrefModule(val context: Context) : LearningSharedPref(context){
    private val mContext = context

    fun getSharedPreferenceInstance(): SharedPreferences {
        return mContext.getSharedPreferences("my_learning", Context.MODE_PRIVATE)
    }

    fun saveUserId(key : String, value : String){
        save(key,value)
    }



}