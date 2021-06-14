package com.news.perform.ui.alphabetical

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.perform.databinding.WeatherItemsBinding
import com.news.perform.model.WeatherDataList

class AlphabeticalRecyclerView(private val weatherData: List<WeatherDataList>,
                               private val clickListener:(position: Long) -> Unit): RecyclerView.Adapter<AlphabeticalRecyclerView.ItemHolder>() {

    private var weatherItemsBinding: WeatherItemsBinding? = null
    private val binding get() = weatherItemsBinding!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        weatherItemsBinding = WeatherItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(weatherData[position])
    }

    override fun getItemCount() = weatherData.size

    inner class ItemHolder(itemView: WeatherItemsBinding): RecyclerView.ViewHolder(itemView.root){
        fun bind(weatherData: WeatherDataList){
            val weatherCondition = if(weatherData.weatherCondition.isEmpty()){
                binding.condition.setTypeface(null, Typeface.ITALIC)
                "Unknown"
            } else {
                weatherData.weatherCondition
            }
            val temperature = if(weatherData.weatherTemp.isEmpty()){
                ""
            } else {
                weatherData.weatherTemp + "°"
            }

            binding.condition.text = weatherCondition
            binding.location.text = weatherData.locationName
            binding.temperature.text = temperature
            binding.root.setOnClickListener {
                clickListener(weatherData.venueId)
            }
        }
    }
}