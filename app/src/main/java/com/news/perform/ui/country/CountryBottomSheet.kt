package com.news.perform.ui.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.news.perform.databinding.CountryBottomSheetBinding
import com.news.perform.utils.EndlessRecyclerViewScrollListener
import com.news.perform.utils.getViewModel

class CountryBottomSheet: BottomSheetDialogFragment() {

    private var countryBottomSheetBinding: CountryBottomSheetBinding? = null
    private val binding get() = countryBottomSheetBinding!!
    private val countryViewModel by lazy { getViewModel(CountryViewModel::class.java) }
    private val itemsArray = arrayListOf<String>()
    private val weatherAdapter by lazy { CountryAdapter(itemsArray) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        countryBottomSheetBinding = CountryBottomSheetBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.countryRecyclerView.layoutManager = linearLayoutManager
        binding.countryRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        countryViewModel.getCountryNames().observe(viewLifecycleOwner){ weatherData ->
            itemsArray.addAll(weatherData)
            binding.countryRecyclerView.adapter = weatherAdapter
            weatherAdapter.notifyDataSetChanged()
        }
    }
}