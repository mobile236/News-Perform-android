package com.news.perform.ui.list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.news.perform.model.DataType
import com.news.perform.model.WeatherDataList
import com.news.perform.ui.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application): BaseViewModel(application) {


    fun getWeatherData(dataType: DataType, size: Int): LiveData<List<WeatherDataList>>{
        isLoading.postValue(true)
        val weatherData = MutableLiveData<List<WeatherDataList>>()
        viewModelScope.launch(Dispatchers.IO){
            val weatherRepo = when (dataType) {
                DataType.ALPHABETICAL -> {
                    getWeather(size)
                }
                DataType.LASTUPDATED -> {
                    getLastUpdated(size)
                }
                else -> {
                    getTemperature(size)
                }
            }
            weatherRepo.collect { weatherDataList ->
                weatherData.postValue(weatherDataList)
                isLoading.postValue(false)
            }
        }
        return weatherData
    }

    private suspend fun getWeather(size: Int) = weatherRepository.getWeatherData(size)

    private fun getLastUpdated(size: Int) = weatherRepository.getWeatherDataByLastUpdated(size)

    private fun getTemperature(size: Int) = weatherRepository.getWeatherDataByTemperature(size)

}