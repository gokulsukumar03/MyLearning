package com.android.mylearning.appconfig.dagger
import com.android.mylearning.appconfig.component.DaggerApplicationComponent
import com.android.mylearning.appconfig.module.CommonModule
import com.android.mylearning.appconfig.networkrepo.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector

class MyLearningApplication : ApplicationDelegation(), HasAndroidInjector{

    internal fun initApplicationComponents(){
        DaggerApplicationComponent.builder()
            .networkModule(NetworkModule())
            .commonModule(CommonModule())
            .build().inject(this)

    }

    override fun injectIfNecessary() {
        if(mDispatchingAndroidInjector==null){
            synchronized(this){
                if(mDispatchingAndroidInjector==null){
                    initApplicationComponents()
                }
            }
        }
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        injectIfNecessary()
        return mDispatchingAndroidInjector
    }

}