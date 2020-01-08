package com.android.mylearning.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.mylearning.backgroundservice.BackgroundServiceActivity
import com.android.mylearning.foregroundservice.ForegroundServiceActivity

class MainViewModel : ViewModel(){

    var mLearningMutableLiveData = MutableLiveData<ArrayList<LearningDto>>()
    private var mLearningList = ArrayList<LearningDto>()

    fun loadLearning(){
        mLearningList.add(LearningDto("Foreground Service", ForegroundServiceActivity().javaClass))
        mLearningList.add(LearningDto("Background Service", BackgroundServiceActivity().javaClass))
        mLearningMutableLiveData.value=mLearningList
    }
}