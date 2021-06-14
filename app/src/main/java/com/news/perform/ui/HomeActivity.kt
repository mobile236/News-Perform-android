package com.news.perform.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.news.perform.R
import com.news.perform.databinding.ActivityHomeBinding
import com.news.perform.ui.country.CountryBottomSheet

class HomeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.toolbar.title = "Weather"
        supportFragmentManager.commit {
            replace(R.id.frameLayout, HomeFragment())
        }
        buttonClick()
    }

    private fun buttonClick(){
        binding.filterButton.setOnClickListener {
            CountryBottomSheet().show(supportFragmentManager, "countryList" )
        }
    }
}