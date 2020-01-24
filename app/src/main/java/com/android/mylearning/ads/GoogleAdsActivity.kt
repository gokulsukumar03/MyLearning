package com.android.mylearning.ads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.mylearning.R
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

class GoogleAdsActivity : GlobalActivity(), HasAndroidInjector {
    
    @Inject lateinit var mDispatchingAndroidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_google_ads)
        adView.loadAd(adRequest)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mDispatchingAndroidInjector
    }
}
