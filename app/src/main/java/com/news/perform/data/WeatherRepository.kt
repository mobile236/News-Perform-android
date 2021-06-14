package com.news.perform.data

import com.news.perform.data.local.dao.CountryDao
import com.news.perform.data.local.dao.SportDao
import com.news.perform.data.local.dao.WeatherDao
import com.news.perform.data.network.WeatherService
import com.news.perform.model.Country
import com.news.perform.model.Sport
import com.news.perform.model.WeatherDataList
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

class WeatherRepository(private val weatherService: WeatherService,
                        private val weatherDao: WeatherDao,
                        private val sportDao: SportDao,
                        private val countryDao: CountryDao) {


    suspend fun getWeatherData(): Flow<List<WeatherDataList>> {
        try {
            val weatherData = weatherService.getWeatherData()
            val weatherBody = weatherData.body()
            if(weatherData.isSuccessful && weatherBody != null){
                if(weatherBody.weatherDataList.isNotEmpty()){
                    weatherBody.weatherDataList.forEach { weatherDataList ->

                        sportDao.insertData(Sport(0, weatherDataList.venueId,
                            weatherDataList.sport.description, weatherDataList.sport.sportId))

                        countryDao.insertData(Country(0, weatherDataList.venueId,
                        weatherDataList.country.countryId, weatherDataList.country.countryName))

                        weatherDao.insertData(weatherDataList)
                    }
                }
            }
        } catch (exception: Exception){ }
        return weatherDao.getWeather()
    }

}