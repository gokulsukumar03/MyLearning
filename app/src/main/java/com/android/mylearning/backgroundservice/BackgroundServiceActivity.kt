package com.android.mylearning.backgroundservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.mylearning.R

class BackgroundServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_service)
    }

    override fun onStart() {
        super.onStart()
        startService(Intent(this, BackgroundService::class.java))
    }


}
