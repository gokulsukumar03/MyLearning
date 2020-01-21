package com.android.mylearning.appconfig.dagger

import com.android.mylearning.daggersample.DaggerSampleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LearningApplicationModule {

    @ContributesAndroidInjector(modules = [DaggerSampleInnerModule::class])
    @ActivityScope
    abstract fun mDaggerSampleActivity() : DaggerSampleActivity
}