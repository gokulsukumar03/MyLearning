package com.android.mylearning.appconfig.module

import android.content.Context
import android.content.SharedPreferences
import com.android.mylearning.appconfig.logger.SDKLogger
import com.android.mylearning.appconfig.shared.SharedPrefModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CommonModule(context: Context) {

    private val mContext = context

    @Singleton
    @Provides
    fun provideLogger() : SDKLogger{
        return SDKLogger().getInstance()
    }

    @Singleton
    @Provides
    fun  provideContext() : Context{
        return mContext.applicationContext
    }

    @Singleton
    @Provides
    fun provideSharedPreference() : SharedPreferences{
        return SharedPrefModule(mContext).getSharedPreferenceInstance()
    }
}