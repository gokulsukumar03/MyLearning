package com.android.mylearning.backgroundservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class BackgroundBroadcastReceiver  : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals("action")) {
           // Toast.makeText(context, "receiver ${intent?.getIntExtra("data", -1)}", Toast.LENGTH_LONG).show()
            val i = Intent("action")
            i.putExtra("data", "Background service kills in ${intent?.getIntExtra("data", -1)}")
            context!!.sendBroadcast(i)
        }

    }

}