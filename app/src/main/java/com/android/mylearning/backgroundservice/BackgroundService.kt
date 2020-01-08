package com.android.mylearning.backgroundservice

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.android.mylearning.R

class BackgroundService : Service(){
    private val CHANNEL_ID = "channel_id"
    private var handler : Handler?=null
    private var runnable : Runnable?=null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var manager : NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Background Service")
            .setContentText("Testing Background Service")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setColor(resources.getColor(R.color.colorAccent))
            .setOngoing(true)
            .setVibrate(longArrayOf(100,200,300))
            .build()
        manager.notify(2, notification)

        handler = Handler()
        runnable = Runnable { manager.cancel(2)
        stopSelf()
        handler?.removeCallbacks(runnable)
        }
        handler?.postDelayed(runnable,10000)
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}