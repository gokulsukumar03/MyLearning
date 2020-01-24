package com.android.mylearning.ads

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_google_ads.*
import javax.inject.Inject

abstract class GlobalActivity : AppCompatActivity(){

    lateinit var adRequest : AdRequest
    @Inject lateinit var context : Context

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         MobileAds.initialize(this)
         adRequest = AdRequest.Builder().build()
         adRequest.isTestDevice(this)
     }

     override fun onResume() {
         super.onResume()
         context.let {
             Toast.makeText(context, "context working", Toast.LENGTH_SHORT).show()
         }
     }
     override fun onDestroy() {
         super.onDestroy()
     }


}