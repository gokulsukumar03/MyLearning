package com.android.mylearning.appconfig.module

import com.android.mylearning.appconfig.logger.SDKLogger
import dagger.Module
import dagger.Provides

@Module
class CommonModule {
    @Provides
    fun provideLogger() : SDKLogger?{
        return SDKLogger().getInstance()
    }
}