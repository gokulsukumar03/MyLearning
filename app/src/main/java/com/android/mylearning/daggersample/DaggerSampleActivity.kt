package com.android.mylearning.daggersample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mylearning.R
import com.android.mylearning.appconfig.logger.SDKLogger
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class DaggerSampleActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject lateinit var logger : SDKLogger
    @Inject lateinit var mDispatchingAndroidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_sample)
    }

    override fun onResume() {
        super.onResume()
            logger.d("testing", "testing")
            Toast.makeText(this, "dagger working", Toast.LENGTH_SHORT).show()
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return mDispatchingAndroidInjector
    }
}
