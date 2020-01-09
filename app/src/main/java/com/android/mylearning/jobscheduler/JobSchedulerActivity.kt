package com.android.mylearning.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mylearning.R
import kotlinx.android.synthetic.main.activity_job_scheduler.*


class JobSchedulerActivity : AppCompatActivity() {

    private val JOB_ID = 0
    private var mScheduler: JobScheduler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_scheduler)
        mScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
        scheduleJobBtn.setOnClickListener {
            scheduleJob()
        }

        cancelJobBtn.setOnClickListener {
            cancelJob()
        }
    }

    fun scheduleJob(){
        val serviceName = ComponentName(packageName, JobSchedulerService::class.java.getName())
        val builder = JobInfo.Builder(JOB_ID, serviceName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setRequiresCharging(true)
            //.setPeriodic(100)
            .setOverrideDeadline(0)
            .setPersisted(true)
            val myJobInfo = builder
                .build()
            mScheduler!!.schedule(myJobInfo)
            Toast.makeText(this, "job_scheduled", Toast.LENGTH_SHORT)
                .show()
    }

    fun cancelJob(){
        mScheduler?.cancelAll()
        mScheduler=null
        Toast.makeText(this, "Job Scheduler Cancelled", Toast.LENGTH_LONG).show()
    }
}
