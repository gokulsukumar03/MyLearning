package com.android.mylearning.nativeads

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mylearning.R
import com.bumptech.glide.load.ImageHeaderParser
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.VideoOptions
import com.google.android.gms.ads.doubleclick.PublisherAdRequest
import com.google.android.gms.ads.formats.MediaView
import com.google.android.gms.ads.formats.NativeAdOptions
import com.google.android.gms.ads.formats.UnifiedNativeAd
import kotlinx.android.synthetic.main.activity_google_ads.*
import kotlinx.android.synthetic.main.activity_native_ads.*

class NativeAdsActivity : AppCompatActivity() {

    private var nativeAd: UnifiedNativeAd? = null
    private val AD_MANAGER_AD_UNIT_ID = "/1947299539/native-video-ads"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_ads)
        loadNativeAd()
    }


    private fun loadNativeAd() {
        val nativeAdBuilder = AdLoader.Builder(this, AD_MANAGER_AD_UNIT_ID)
        nativeAdBuilder.forUnifiedNativeAd {
            nativeAd?.destroy()
            nativeAd = it

            val icon = unifiedNativeAdView.findViewById<ImageView>(R.id.adsIcon)
            unifiedNativeAdView.iconView = icon

            val headline = unifiedNativeAdView.findViewById<TextView>(R.id.headline)
            unifiedNativeAdView.headlineView = headline

            val body = unifiedNativeAdView.findViewById<TextView>(R.id.adsBody)
            unifiedNativeAdView.bodyView = body

            val media = unifiedNativeAdView.findViewById<MediaView>(R.id.mediaView)
            unifiedNativeAdView.mediaView = media

            val action = unifiedNativeAdView.findViewById<Button>(R.id.actionButton)
            unifiedNativeAdView.callToActionView = action


            nativeAd?.let {
             native->
                native.body?.let { adBody ->
                    body.text = adBody
                }

                native.icon?.let {
                    adIcon->
                    icon.setImageDrawable(adIcon.drawable)
                }

                native.headline?.let {
                    adHeadline->
                    headline.text=adHeadline
                }


                native.mediaContent?.let { adMedia ->
                    media.setMediaContent(adMedia)
                }

                native.callToAction?.let {
                    adAction->
                    action.text=adAction
                }

                unifiedNativeAdView.setNativeAd(nativeAd)

            }
        }

        val videoOptions = VideoOptions.Builder()
            .setStartMuted(true)
            .build()

        val adOptions = NativeAdOptions.Builder()
            .setVideoOptions(videoOptions)
            .build()

        nativeAdBuilder.withNativeAdOptions(adOptions)

        val adLoader: AdLoader = nativeAdBuilder.withAdListener(object : AdListener() {
            override fun onAdFailedToLoad(errorCode: Int) {

                Toast.makeText(this@NativeAdsActivity, "Failed to load native ad: " + errorCode, Toast.LENGTH_SHORT).show() }
        }).build()

        adLoader.loadAd(PublisherAdRequest.Builder().build())


    }

}
