package com.android.mylearning.appconfig.dagger

import com.android.mylearning.ads.GoogleAdsActivity
import com.android.mylearning.daggersample.DaggerSampleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LearningApplicationModule {

    @ContributesAndroidInjector(modules = [DaggerSampleInnerModule::class])
    @ActivityScope
    abstract fun mDaggerSampleActivity() : DaggerSampleActivity

    @ContributesAndroidInjector(modules = [GoogleInnerModule::class])
    @ActivityScope
    abstract fun mGoogleActivity() : GoogleAdsActivity
}