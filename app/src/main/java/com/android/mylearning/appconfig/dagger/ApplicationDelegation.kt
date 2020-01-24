package com.android.mylearning.appconfig.dagger

import android.app.Application
import com.android.mylearning.appconfig.logger.SDKLogger
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class ApplicationDelegation : Application() {
    var mDispatchingAndroidInjector : DispatchingAndroidInjector<Any>?=null @Inject set
    override fun onCreate() {
        super.onCreate()
        injectIfNecessary()
    }
    abstract fun injectIfNecessary()
}