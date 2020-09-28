package com.max.kkbox.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.max.kkbox.home.item.release.NewReleaseItemFragment
import com.max.kkbox.home.item.rank.RankItemFragment

class HomeAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> NewReleaseItemFragment()
            else -> RankItemFragment()
        }
    }

    override fun getCount(): Int = HomeTypeFilter.values().size

    override fun getPageTitle(position: Int): CharSequence? {
        return HomeTypeFilter.values()[position].value
    }
}