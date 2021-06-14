package com.news.perform.ui.list

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.news.perform.model.DataType

class ViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment){


    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        val weatherFragment = WeatherFragment()
        val bundle = when (position) {
            0 -> {
                bundleOf("DATATYPE" to DataType.ALPHABETICAL)
            }
            1 -> {
                bundleOf("DATATYPE" to DataType.TEMPERATURE)
            }
            else -> {
                bundleOf("DATATYPE" to DataType.LASTUPDATED)
            }
        }
        weatherFragment.arguments = bundle
        return weatherFragment
    }
}