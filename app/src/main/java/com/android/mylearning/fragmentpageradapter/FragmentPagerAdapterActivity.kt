package com.android.mylearning.fragmentpageradapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import com.android.mylearning.R
import kotlinx.android.synthetic.main.activity_fragment_pager_adapter.*

class FragmentPagerAdapterActivity : AppCompatActivity() {

    var myFragmentPagerAdapter : MyFragmentPagerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_pager_adapter)
        setupPagerAdapter()
    }

    fun setupPagerAdapter(){
        myFragmentPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        viewPager.adapter=myFragmentPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
