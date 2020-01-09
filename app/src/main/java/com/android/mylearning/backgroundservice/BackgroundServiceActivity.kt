package com.android.mylearning.backgroundservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mylearning.R
import kotlinx.android.synthetic.main.activity_background_service.*


class BackgroundServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_service)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        startService(Intent(this, BackgroundService::class.java))
        registerReceiver(broadcastReceiver, IntentFilter("action"))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }

    private var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            val bundleIntent = intent.extras
            val bundleData = bundleIntent!!.getString("data")
             //   Toast.makeText(context, bundleData, Toast.LENGTH_LONG).show()
            updateTv.text=bundleData
        }
    }
    }

