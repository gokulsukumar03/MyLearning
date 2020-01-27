package com.android.mylearning.fragmentstateadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.android.mylearning.fragmentpageradapter.*

class MyFragmentStateAdapter(val fm : FragmentManager, val behaviour : Int) : FragmentStatePagerAdapter(fm,behaviour) {

    override fun getItem(position: Int): Fragment {
        var fragment : Fragment
        when(position){
            0->{ fragment = FootballFragment().newInstance()}
            1->{ fragment = CricketFragment().newInstance()}
            2->{ fragment = SwimmingFragment().newInstance()}
            3->{ fragment = HockeyFragment().newInstance()}
            4->{ fragment = VollyballFragment().newInstance()}
            else->{fragment = FootballFragment().newInstance()}
        }
        return fragment
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->{ return TabTitle.FOOTBALL}
            1->{ return TabTitle.CRICKET}
            2->{ return TabTitle.SWIMMING}
            3->{ return TabTitle.HOCKEY}
            4->{ return TabTitle.VOLLEYBALL}
            else->{return TabTitle.FOOTBALL}
        }
    }

}