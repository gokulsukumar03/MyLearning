package com.android.mylearning.daggersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.mylearning.R
import com.android.mylearning.appconfig.logger.SDKLogger
import javax.inject.Inject

class DaggerSampleActivity : AppCompatActivity() {

    var logger : SDKLogger?=null @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_sample)
    }

    override fun onResume() {
        super.onResume()
        logger?.d("testing", "testing")
    }
}
