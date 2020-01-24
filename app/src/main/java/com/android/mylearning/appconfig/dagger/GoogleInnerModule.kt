package com.android.mylearning.appconfig.dagger

import android.app.Activity
import com.android.mylearning.ads.GoogleAdsActivity
import com.android.mylearning.daggersample.DaggerSampleActivity
import dagger.Binds
import dagger.Module

@Module
abstract class GoogleInnerModule {
    @Binds abstract fun bindActivity(activity: GoogleAdsActivity) : Activity
}