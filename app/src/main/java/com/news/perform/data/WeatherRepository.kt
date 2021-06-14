package com.news.perform.data

import com.news.perform.data.local.dao.WeatherDao
import com.news.perform.data.network.WeatherService
import com.news.perform.model.WeatherDataList
import java.lang.Exception

class WeatherRepository(private val weatherService: WeatherService,
                        private val weatherDao: WeatherDao) {


    suspend fun getWeatherData(): List<WeatherDataList>{
        try {
            val weatherData = weatherService.getWeatherData()
            val weatherBody = weatherData.body()
            if(weatherData.isSuccessful && weatherBody != null){
                return weatherBody.weatherDataList
            }
        } catch (exception: Exception){

        }
        return listOf()
    }

}