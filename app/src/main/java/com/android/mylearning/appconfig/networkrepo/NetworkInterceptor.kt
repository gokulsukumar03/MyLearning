package com.android.mylearning.appconfig.networkrepo

import okhttp3.Interceptor
import okhttp3.Response
import java.net.HttpURLConnection
import javax.inject.Singleton

@Singleton
class NetworkInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder().build()
        val response  = chain.proceed(requestBuilder)
        if(response.code()!=HttpURLConnection.HTTP_OK){

        }
        return response
    }

}