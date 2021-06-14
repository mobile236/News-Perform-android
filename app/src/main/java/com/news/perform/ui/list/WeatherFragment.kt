package com.news.perform.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.news.perform.databinding.FragmentAlphabeticalBinding
import com.news.perform.model.DataType
import com.news.perform.model.WeatherDataList
import com.news.perform.utils.EndlessRecyclerViewScrollListener
import com.news.perform.utils.getViewModel

class WeatherFragment: Fragment() {

    private var fragmentAlphabeticalFragment: FragmentAlphabeticalBinding? = null
    private val binding get() = fragmentAlphabeticalFragment!!
    private val weatherViewModel by lazy { getViewModel(WeatherViewModel::class.java) }
    private val dataType by lazy { arguments?.get("DATATYPE") as DataType }
    private val itemsArray = arrayListOf<WeatherDataList>()
    private val weatherAdapter by lazy { WeatherRecyclerView(itemsArray) { data -> itemClicked(data) } }


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
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.weatherList.layoutManager = linearLayoutManager
        binding.weatherList.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        weatherViewModel.getWeatherData(dataType, 1).observe(viewLifecycleOwner){ weatherData ->
            itemsArray.addAll(weatherData)
            binding.weatherList.adapter = weatherAdapter
            weatherAdapter.notifyDataSetChanged()
        }
        val scrollListener = object: EndlessRecyclerViewScrollListener(linearLayoutManager){
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                weatherViewModel.getWeatherData(dataType, page).observe(viewLifecycleOwner){ weatherData ->
                    itemsArray.addAll(weatherData)
                    binding.weatherList.adapter = weatherAdapter
                    weatherAdapter.notifyDataSetChanged()
                }
            }
        }
        binding.weatherList.addOnScrollListener(scrollListener)

        weatherViewModel.isLoading.observe(viewLifecycleOwner){ isLoading ->
            binding.swipeContainerLayout.isRefreshing = isLoading
        }

    }

    private fun itemClicked(venueId: Long){

    }

}