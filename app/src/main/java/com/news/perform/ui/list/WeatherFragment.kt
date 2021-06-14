package com.news.perform.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.news.perform.databinding.FragmentAlphabeticalBinding
import com.news.perform.model.DataType
import com.news.perform.utils.getViewModel

class WeatherFragment: Fragment() {

    private var fragmentAlphabeticalFragment: FragmentAlphabeticalBinding? = null
    private val binding get() = fragmentAlphabeticalFragment!!
    private val weatherViewModel by lazy { getViewModel(WeatherViewModel::class.java) }
    private val dataType by lazy { arguments?.get("DATATYPE") as DataType }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentAlphabeticalFragment = FragmentAlphabeticalBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView(){
        binding.weatherList.layoutManager = LinearLayoutManager(requireContext())
        binding.weatherList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        weatherViewModel.getWeatherData(dataType).observe(viewLifecycleOwner){ weatherData ->
            val alphabeticalRecyclerView = WeatherRecyclerView(weatherData) { data ->
                itemClicked(data)
            }
            binding.weatherList.adapter = alphabeticalRecyclerView
        }
        weatherViewModel.isLoading.observe(viewLifecycleOwner){ isLoading ->
            binding.swipeContainerLayout.isRefreshing = isLoading
        }
    }

    private fun itemClicked(venueId: Long){

    }
}