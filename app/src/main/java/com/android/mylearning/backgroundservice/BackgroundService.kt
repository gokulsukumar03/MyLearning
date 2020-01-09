package com.android.mylearning.backgroundservice

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.Handler
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.android.mylearning.R

class BackgroundService : Service(){
    private val CHANNEL_ID = "channel_id"
    var countDownTimer : CountDownTimer?=null
    var count =10

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

        val broadcastIntent = Intent(this, BackgroundBroadcastReceiver::class.java)
        broadcastIntent.action="action"

         countDownTimer = object : CountDownTimer(10000,1000){
            override fun onFinish() {
                manager.cancel(2)
                stopSelf()
            }

            override fun onTick(millisUntilFinished: Long) {
                Log.d("Testing" , "!!!  $millisUntilFinished")
                broadcastIntent.putExtra("data" , count--)
                sendBroadcast(broadcastIntent)
            }

        }
        countDownTimer?.start()
        return START_STICKY
    }

    override fun onDestroy() {
        countDownTimer?.cancel()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}