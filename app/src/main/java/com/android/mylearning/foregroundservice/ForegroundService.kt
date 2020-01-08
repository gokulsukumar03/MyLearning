package com.android.mylearning.foregroundservice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.android.mylearning.R


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ForegroundService : Service(){

    private val CHANNEL_ID = "channel_id"

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText("Testing Foreground Service")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setColor(resources.getColor(R.color.colorAccent))
            .build()
        startForeground(1, notification)
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun createNotificationChannel(){
        var manager  : NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(CHANNEL_ID, "Service", NotificationManager.IMPORTANCE_HIGH)
            serviceChannel.enableVibration(true)
            serviceChannel.setShowBadge(true)
            serviceChannel.vibrationPattern=
                longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}