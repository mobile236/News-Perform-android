package com.news.perform.ui.alphabetical

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.news.perform.databinding.FragmentAlphabeticalBinding
import com.news.perform.utils.getViewModel

class AlphabeticalFragment: Fragment() {

    private var fragmentAlphabeticalFragment: FragmentAlphabeticalBinding? = null
    private val binding get() = fragmentAlphabeticalFragment!!
    private val alphabeticalViewModel by lazy { getViewModel(AlphabeticalViewModel::class.java) }

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
        alphabeticalViewModel.getWeatherData().observe(viewLifecycleOwner){ weatherData ->
            val alphabeticalRecyclerView = AlphabeticalRecyclerView(weatherData) { data ->
                itemClicked(data)
            }
            binding.weatherList.adapter = alphabeticalRecyclerView
        }
        alphabeticalViewModel.isLoading.observe(viewLifecycleOwner){ isLoading ->
            binding.swipeContainerLayout.isRefreshing = isLoading
        }
    }

    private fun itemClicked(venueId: Long){
        
    }
}