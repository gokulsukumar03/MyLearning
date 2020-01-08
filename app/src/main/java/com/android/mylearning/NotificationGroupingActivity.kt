package com.android.mylearning

import android.app.NotificationManager
import android.app.Service
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_notification_grouping.*
import kotlin.random.Random

class NotificationGroupingActivity : AppCompatActivity() {

    val SUMMARY_ID = 0
    val GROUP_KEY = "group_key"
    val CHANNEL_ID = "channel_id"
    var  count=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_grouping)
    }

    override fun onStart() {
        super.onStart()
        mCreatePushNotificationBtn.setOnClickListener {
            setGroupNotification(count++)
        }
    }

    override fun onStop() {
        NotificationManagerCompat.from(this).apply {
         cancel(SUMMARY_ID)
        }
        super.onStop()
    }

    private fun setGroupNotification(count : Int) {
        val newMessageNotification1 = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Group title$count")
            .setContentText("You will not believe...$count")
            .setGroup(GROUP_KEY)
            .build()

        val summaryNotification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Summary Notification")
            .setContentText("$count new messages")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setStyle(
                NotificationCompat.InboxStyle()
                    .setSummaryText("Total $count Messages")
            )
            .setGroup(GROUP_KEY)
            .setGroupSummary(true)
            .build()

        NotificationManagerCompat.from(this).apply {
            notify(getRandom(), newMessageNotification1)
            notify(SUMMARY_ID, summaryNotification)
        }
    }

    private fun getRandom() : Int{
        return Random.nextInt(0,10000)
    }
}
