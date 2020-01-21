package com.android.mylearning.appconfig.dagger

import android.app.Activity
import com.android.mylearning.daggersample.DaggerSampleActivity
import dagger.Binds
import dagger.Module

@Module
abstract class DaggerSampleInnerModule {
    @Binds abstract fun bindActivity(activity : DaggerSampleActivity) : Activity
}