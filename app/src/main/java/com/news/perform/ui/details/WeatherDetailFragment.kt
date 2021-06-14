package com.news.perform.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.news.perform.databinding.WeatherDetailsFragmentBinding
import com.news.perform.utils.getViewModel

class WeatherDetailFragment: Fragment() {

    private var weatherDetailsBinding: WeatherDetailsFragmentBinding? = null
    private val binding get() = weatherDetailsBinding!!
    private val venueId by lazy { arguments?.getLong("venueId") ?: 0 }
    private val viewModel by lazy { getViewModel(WeatherDetailViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        weatherDetailsBinding = WeatherDetailsFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData(){
        viewModel.getWeatherById(venueId).observe(viewLifecycleOwner){ weatherData ->
            binding.weatherItems.temperature.text = weatherData.weatherTemp
            binding.weatherItems.location.text = weatherData.locationName
            binding.weatherItems.condition.text = weatherData.weatherCondition
        }
    }
}