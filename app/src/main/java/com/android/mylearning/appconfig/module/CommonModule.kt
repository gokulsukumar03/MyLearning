package com.android.mylearning.appconfig.module

import com.android.mylearning.appconfig.logger.SDKLogger
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CommonModule {
    @Singleton
    @Provides
    fun provideLogger() : SDKLogger{
        return SDKLogger().getInstance()
    }
}