package com.news.perform.ui.alphabetical

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.news.perform.model.WeatherDataList
import com.news.perform.ui.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AlphabeticalViewModel(application: Application): BaseViewModel(application) {


    fun getWeatherData(): LiveData<List<WeatherDataList>>{
        isLoading.postValue(true)
        val weatherData = MutableLiveData<List<WeatherDataList>>()
        viewModelScope.launch(Dispatchers.IO ){
           weatherRepository.getWeatherData().collectLatest { weatherDataList ->
               weatherData.postValue(weatherDataList)
               isLoading.postValue(false)
            }
        }
        return weatherData
    }
}