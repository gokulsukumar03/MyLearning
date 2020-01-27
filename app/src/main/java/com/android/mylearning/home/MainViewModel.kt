package com.android.mylearning.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.mylearning.ads.GoogleAdsActivity
import com.android.mylearning.notificationgroup.NotificationGroupingActivity
import com.android.mylearning.backgroundservice.BackgroundServiceActivity
import com.android.mylearning.daggersample.DaggerSampleActivity
import com.android.mylearning.foregroundservice.ForegroundServiceActivity
import com.android.mylearning.fragmentpageradapter.FragmentPagerAdapterActivity
import com.android.mylearning.fragmentstateadapter.FragmentStateAdapterActivity
import com.android.mylearning.jobscheduler.JobSchedulerActivity
import com.android.mylearning.workmanager.WorkManagerActivity

class MainViewModel : ViewModel(){

    var mLearningMutableLiveData = MutableLiveData<ArrayList<LearningDto>>()
    private var mLearningList = ArrayList<LearningDto>()

    fun loadLearning(){
        mLearningList.add(LearningDto("Foreground Service", ForegroundServiceActivity().javaClass))
        mLearningList.add(LearningDto("Background Service", BackgroundServiceActivity().javaClass))
        mLearningList.add(LearningDto("Grouping Push Notification", NotificationGroupingActivity().javaClass))
        mLearningList.add(LearningDto("Job Scheduler", JobSchedulerActivity().javaClass))
        mLearningList.add(LearningDto("Work Manager", WorkManagerActivity().javaClass))
        mLearningList.add(LearningDto("Dagger", DaggerSampleActivity().javaClass))
        mLearningList.add(LearningDto("Google Ads", GoogleAdsActivity().javaClass))
        mLearningList.add(LearningDto("Fragment Pager Adapter", FragmentPagerAdapterActivity().javaClass))
        mLearningList.add(LearningDto("Fragment State Adapter", FragmentStateAdapterActivity().javaClass))
        mLearningMutableLiveData.value=mLearningList
    }
}