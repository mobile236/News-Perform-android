package com.news.perform.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.news.perform.ui.alphabetical.AlphabeticalFragment

class ViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment){


    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return AlphabeticalFragment()
    }
}