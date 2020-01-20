package com.android.mylearning.appconfig.networkrepo

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule{
    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. LoginRetrofitService).
    // Function parameters are the dependencies of this type.

    @Singleton
    @Provides
    fun provideRetrofitService(): NetworkRequest{
        return Retrofit.Builder()
            .baseUrl("")
            .build()
            .create(NetworkRequest::class.java)
    }
}