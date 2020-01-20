package com.android.mylearning.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Time
import android.util.TimeUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.*
import com.android.mylearning.R
import kotlinx.android.synthetic.main.activity_work_manager.*
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
    }

    override fun onStart() {
        super.onStart()
        insertBtn.setOnClickListener {
            val constraints =
                Constraints.Builder().setRequiredNetworkType(NetworkType.NOT_REQUIRED).build()
            val oneTimeWorkRequest = OneTimeWorkRequest.Builder(OneTimeWorker::class.java)
                .setConstraints(constraints)
                .addTag("insert")
                .build()

            WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
                .observe(this, Observer { workInfo ->
                    if(workInfo!=null) {
                        if (workInfo.state == WorkInfo.State.SUCCEEDED) {
                            Toast.makeText(this, "SUCCEEDED", Toast.LENGTH_LONG).show()
                        } else if(workInfo.state==WorkInfo.State.FAILED) {
                            Toast.makeText(this, "FAILED", Toast.LENGTH_LONG).show()
                        }
                    }
                })

        }

        periodicBtn.setOnClickListener {
            val periodicWorkRequest = PeriodicWorkRequest.Builder(PeriodicTimeWorker::class.java,3 * 60 * 1000L,TimeUnit.SECONDS,
                3 * 60 * 1000L, TimeUnit.SECONDS)
                .addTag("periodic")
                .build()

            WorkManager.getInstance(this).enqueue(periodicWorkRequest)
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.id)
                .observe(this, Observer {
                    workInfo->
                    if(workInfo!=null) {
                        if (workInfo.state == WorkInfo.State.SUCCEEDED) {
                            Toast.makeText(this, "Periodic SUCCEEDED", Toast.LENGTH_LONG).show()
                        } else if(workInfo.state==WorkInfo.State.RUNNING) {
                            Toast.makeText(this, "Periodic Running", Toast.LENGTH_LONG).show()
                        }
                        else if(workInfo.state==WorkInfo.State.ENQUEUED) {
                            Toast.makeText(this, "Periodic Enqueued", Toast.LENGTH_LONG).show()
                        }
                    }
                })
        }
    }

    override fun onStop() {

        super.onStop()
    }
}