package com.news.perform.ui.list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.news.perform.model.DataType
import com.news.perform.model.WeatherDataList
import com.news.perform.ui.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application): BaseViewModel(application) {


    fun getWeatherData(dataType: DataType): LiveData<List<WeatherDataList>>{
        isLoading.postValue(true)
        val weatherData = MutableLiveData<List<WeatherDataList>>()
        viewModelScope.launch(Dispatchers.IO){
            val weatherRepo = when (dataType) {
                DataType.ALPHABETICAL -> {
                    getWeather()
                }
                DataType.LASTUPDATED -> {
                    getLastUpdated()
                }
                else -> {
                    getTemperature()
                }
            }
            weatherRepo.collectLatest { weatherDataList ->
                weatherData.postValue(weatherDataList)
                isLoading.postValue(false)
            }
        }
        return weatherData
    }

    private suspend fun getWeather() = weatherRepository.getWeatherData()

    private fun getLastUpdated() = weatherRepository.getWeatherDataByLastUpdated()

    private fun getTemperature() = weatherRepository.getWeatherDataByTemperature()

}