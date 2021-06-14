package com.news.perform.data.network

import com.news.perform.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET


interface WeatherService {

    @GET("weather.json")
    suspend fun getWeatherData(): Response<WeatherModel>

}