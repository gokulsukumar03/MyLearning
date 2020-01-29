package com.android.mylearning.fragmentpageradapter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import com.android.mylearning.R
import kotlinx.android.synthetic.main.activity_fragment_pager_adapter.*
import org.w3c.dom.Entity

class FragmentPagerAdapterActivity : AppCompatActivity() {

    var myFragmentPagerAdapter : MyFragmentPagerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_pager_adapter)
        populateFeeds()
        setupPagerAdapter()
    }

    fun setupPagerAdapter(){
        myFragmentPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        viewPager.adapter=myFragmentPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    fun populateFeeds(){

        var adsConfig :AdsConfig
        var feeds : Feeds
        var feed : HashMap<String, Feeds>

        adsConfig = AdsConfig()
        adsConfig.ads_enabled=true
        adsConfig.refresh=2
        adsConfig.limit=10

        feeds = Feeds()
        feeds.ads_position=1
        feeds.placement_id=1000
        feeds.mute=false

        feed = HashMap()
        feed["Native"] = feeds
        adsConfig.placement=feed

        adsConfig = AdsConfig()
        adsConfig.ads_enabled=true
        adsConfig.refresh=2
        adsConfig.limit=10

        feeds = Feeds()
        feeds.ads_position=2
        feeds.placement_id=2000
        feeds.mute=true

        feed["Video"] = feeds
        adsConfig.placement=feed


        val entryIterator : Iterator<Map.Entry<String, Feeds>>
            entryIterator = (adsConfig.placement as HashMap<String, Feeds>).entries.iterator()
        while (entryIterator.hasNext()){
            val entry = entryIterator.next()
            val feedAds = entry.value
            Log.d("!!!  ads  " , feedAds.ads_position.toString())
        }

    }
}
