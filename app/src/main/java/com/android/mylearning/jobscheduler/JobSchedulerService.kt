package com.android.mylearning.jobscheduler

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import com.android.mylearning.R
import com.android.mylearning.home.MainActivity
import kotlin.random.Random


class JobSchedulerService : JobService(){
    // Notification channel ID.
    private val PRIMARY_CHANNEL_ID = "primary_notification_channel"
    // Notification manager.
    var mNotifyManager: NotificationManager? = null

    /**
     * Called by the system once it determines it is time to run the job.
     *
     * @param jobParameters Contains the information about the job.
     * @return Boolean indicating whether or not the job was offloaded to a
     * separate thread.
     * In this case, it is false since the notification can be posted on
     * the main thread.
     */
    override fun onStartJob(params: JobParameters?): Boolean {
        // Create the notification channel.
        // Create the notification channel.
        createNotificationChannel()
        // Set up the notification content intent to launch the app when
        // clicked.
        // Set up the notification content intent to launch the app when
        // clicked.
        val contentPendingIntent = PendingIntent.getActivity(
            this, 0, Intent(this, MainActivity::class.java), PendingIntent.FLAG_UPDATE_CURRENT
        )

        val builder =
            NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("job_service")
                .setContentText("job_running")
                .setContentIntent(contentPendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true)

        mNotifyManager!!.notify(Random.nextInt(10000), builder.build())
        return false
    }

    /**
     * Called by the system when the job is running but the conditions are no
     * longer met.
     * In this example it is never called since the job is not offloaded to a
     * different thread.
     *
     * @param jobParameters Contains the information about the job.
     * @return Boolean indicating whether the job needs rescheduling.
     */
    override fun onStopJob(params: JobParameters?): Boolean {

        return false
    }

    private fun createNotificationChannel() { // Create a notification manager object.
        mNotifyManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        { // Create the NotificationChannel with all the parameters.
            val notificationChannel = NotificationChannel(
                PRIMARY_CHANNEL_ID,
                "job_service_notification",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.description = "description"
            mNotifyManager!!.createNotificationChannel(notificationChannel)
        }
    }


}