package com.news.perform.ui.details

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.news.perform.model.WeatherDataList
import com.news.perform.ui.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WeatherDetailViewModel(application: Application): BaseViewModel(application) {

    fun getWeatherById(venueId: Long): LiveData<WeatherDataList>{
        val weatherDataLiveData = MutableLiveData<WeatherDataList>()
        viewModelScope.launch(Dispatchers.IO){
            weatherRepository.getWeatherByVenueId(venueId).collectLatest { weatherData ->
                weatherDataLiveData.postValue(weatherData)
            }
        }
        return weatherDataLiveData
    }
}