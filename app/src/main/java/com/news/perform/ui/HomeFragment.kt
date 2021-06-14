package com.news.perform.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.news.perform.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private var fragmentHome: FragmentHomeBinding? = null
    private val binding get() = fragmentHome!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentHome = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTab()
    }

    private fun setTab(){
        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            if(position == 0){
                tab.text = "A-Z"
            } else if(position == 1){
                tab.text = "Temperature"
            } else {
                tab.text = "Last updated"
            }
        }.attach()
    }

}