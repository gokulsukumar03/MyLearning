package com.android.mylearning.fragmentstateadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentPagerAdapter
import com.android.mylearning.R
import com.android.mylearning.fragmentpageradapter.MyFragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_fragment_pager_adapter.*
import java.util.*
import kotlin.collections.ArrayList

class FragmentStateAdapterActivity : AppCompatActivity() {

    var myFragmentStateAdapter: MyFragmentStateAdapter? = null
    private val sports = ArrayList<SportsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_state_adapter)
        setupPagerAdapter()
    }

    fun setupPagerAdapter() {
        myFragmentStateAdapter = MyFragmentStateAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        viewPager.adapter = myFragmentStateAdapter
        viewPager.offscreenPageLimit = 1
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun typeOfSports(){

    }

}
