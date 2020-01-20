package com.android.mylearning.appconfig.component

import com.android.mylearning.appconfig.dagger.ApplicationDelegation
import com.android.mylearning.appconfig.module.CommonModule
import com.android.mylearning.appconfig.networkrepo.NetworkModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, CommonModule::class])
interface ApplicationComponent {
    fun inject(applicationDelegation: ApplicationDelegation)
}